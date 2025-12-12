package laundary_backend.service;

import laundary_backend.entity.Customer;
import laundary_backend.entity.Order;
import laundary_backend.entity.Shop;
import laundary_backend.enums.Status;
import laundary_backend.repository.CustomerRepo;
import laundary_backend.repository.OrderRepo;
import laundary_backend.repository.ShopRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService
{

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final ShopRepo shopRepo;

    /// Constructor  Injection
    public OrderServiceImpl(OrderRepo orderRepo, CustomerRepo customerRepo, ShopRepo shopRepo)
    {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.shopRepo = shopRepo;
    }

    @Override
    @Transactional
    public Order createOrder(Order order)
    {
        if (order.getCustomer() == null || order.getCustomer().getCid() == 0) {
            throw new IllegalArgumentException("Customer id is required");
        }
        Customer customer = customerRepo.findById(order.getCustomer().getCid())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        Shop shop = null;
        if (order.getShop() != null && order.getShop().getSid() != 0) {
            shop = shopRepo.findById(order.getShop().getSid())
                    .orElseThrow(() -> new IllegalArgumentException("Shop not found"));
        }

        order.setCustomer(customer);
        order.setShop(shop);


        if (order.getItems() != null) {
            order.getItems().forEach(i -> i.setOrder(order));
        }
        if (order.getServices() != null) {
            order.getServices().forEach(s -> s.setOrder(order));
        }

        System.out.println(order);
        return orderRepo.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    @Override
    public Order updateStatus(Long orderId, Status status) {
        return orderRepo.findById(orderId)
                .map(order -> {
                    order.setStatus(status);
                    return orderRepo.save(order);
                })
                .orElse(null);
    }

    @Override
    public java.util.List<Order> getOrdersForCustomer(long customerId) {
        return orderRepo.findByCustomer_Cid(customerId);
    }

    @Override
    public java.util.List<Order> getOrdersForShop(long shopId) {
        return orderRepo.findByShop_Sid(shopId);
    }
}

