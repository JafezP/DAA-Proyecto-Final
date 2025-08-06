package com.institute.order.infrastructure.entries.dish;

import com.institute.order.domain.model.dish.Dish;
import com.institute.order.domain.service.dish.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/institute/order/dish")
public class DishController {

    private final DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> findAll() {
        return ResponseEntity.ok(dishService.findAll());
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Dish> findByUid(@PathVariable("uid") String uid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(dishService.findById(uid));
    }

    @PostMapping
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(dishService.save(dish));
    }
}
