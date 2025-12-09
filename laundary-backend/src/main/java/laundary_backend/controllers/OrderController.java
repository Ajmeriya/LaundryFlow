package laundary_backend.controllers;

<<<<<<< HEAD
import laundary_backend.entity.Item;
import laundary_backend.entity.Order;
import laundary_backend.entity.Service;
import laundary_backend.enums.Status;
import laundary_backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    ///  Constructor Injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /// Create Order
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        // Attach back references for cascade save
        if (order.getItems() != null) {
            for (Item item : order.getItems()) {
                item.setOrder(order);
            }
        }
        if (order.getServices() != null) {
            for (Service service : order.getServices()) {
                service.setOrder(order);
            }
        }

        double totalAmount = calculateTotal(order);
        order.setTotalAmount(totalAmount);
        Order savedOrder = orderService.createOrder(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    /// Fetch Order by Id
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable Long orderId
    ) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    /// List orders for customer or shop (based on query param)
    @GetMapping
    public ResponseEntity<List<Order>> listOrders(
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) Long shopId
    ) {
        if (customerId != null) {
            return ResponseEntity.ok(orderService.getOrdersForCustomer(customerId));
        }
        if (shopId != null) {
            return ResponseEntity.ok(orderService.getOrdersForShop(shopId));
        }
        return ResponseEntity.badRequest().build();
    }

    /// Update order status (placed -> confirmed -> delivered/lost/founded/not_found)
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<Order> updateStatus(
            @PathVariable Long orderId,
            @RequestBody Map<String, String> payload
    ) {
        String statusValue = payload.get("status");
        if (statusValue == null) {
            return ResponseEntity.badRequest().build();
        }
        Status status = Status.valueOf(statusValue.toUpperCase());
        Order updated = orderService.updateStatus(orderId, status);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    private double calculateTotal(Order order) {
        double totalAmount = 0;
        int totalCount = 0;

        if (order.getItems() != null) {
            for (Item item : order.getItems()) {
                totalCount += item.getCount();
                totalAmount += item.getCount() * item.getPrice();
            }
        }

        if (order.getServices() != null) {
            for (Service service : order.getServices()) {
                totalAmount += totalCount * service.getPrice();
            }
        }

        return totalAmount;
    }
=======
import laundary_backend.entity.Order;
import laundary_backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController


    ///  Constructor Injection
        this.orderService = orderService;
    }

    @PostMapping
        Order savedOrder = orderService.createOrder(order);

    }

>>>>>>> 0113130 (Created the Create order API)
}

