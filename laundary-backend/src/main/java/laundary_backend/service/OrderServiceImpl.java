package laundary_backend.service;

import laundary_backend.entity.Order;
import laundary_backend.repository.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService
{


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
}
