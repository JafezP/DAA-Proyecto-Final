package com.institute.order.infrastructure.entries.order;

import com.institute.order.domain.model.order.Order;
import com.institute.order.domain.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/institute/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Order> findById(String uid) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.findById(uid));
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(orderService.save(order));
    }
}
