package laundary_backend.service;

import laundary_backend.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService
{
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    Order updateStatus(Long orderId, laundary_backend.enums.Status status);
    java.util.List<Order> getOrdersForCustomer(long customerId);
    java.util.List<Order> getOrdersForShop(long shopId);
}

