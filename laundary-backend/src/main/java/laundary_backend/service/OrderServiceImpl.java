package laundary_backend.service;

import laundary_backend.entity.Order;
import laundary_backend.enums.Status;
import laundary_backend.repository.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService
{

    private final OrderRepo orderRepo;

/// Constructor  Injection
    public OrderServiceImpl(OrderRepo orderRepo)
    {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order createOrder(Order order)
    {
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

