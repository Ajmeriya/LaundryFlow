package laundary_backend.controllers;

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

}
