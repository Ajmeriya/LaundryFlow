package laundary_backend.service;

import laundary_backend.entity.Order;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 0113130 (Created the Create order API)
>>>>>>> 7e02b64 (ok)
@Service
public interface OrderService
{
    Order createOrder(Order order);
<<<<<<< HEAD
    Order getOrderById(Long orderId);
    Order updateStatus(Long orderId, laundary_backend.enums.Status status);
<<<<<<< HEAD
    java.util.List<Order> getOrdersForCustomer(long customerId);
    java.util.List<Order> getOrdersForShop(long shopId);
=======
    List<Order> getOrdersForCustomer(long customerId);
    List<Order> getOrdersForShop(long shopId);
=======
>>>>>>> 0113130 (Created the Create order API)
>>>>>>> 7e02b64 (ok)
}

