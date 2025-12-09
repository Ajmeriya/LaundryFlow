package laundary_backend.controllers;

import laundary_backend.entity.Order;
import laundary_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/orders")
public class OrderController
{

    OrderService orderService;

    ///  Constructor Injection
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

///    Add Order
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order)
    {
        System.out.println(order);
        Order savedOrder = orderService.createOrder(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.OK);
    }

}
