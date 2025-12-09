package laundary_backend.service;

import laundary_backend.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService
{
    Order createOrder(Order order);
}
