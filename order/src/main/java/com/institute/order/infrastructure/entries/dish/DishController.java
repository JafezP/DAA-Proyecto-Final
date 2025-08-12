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
    ResponseEntity<List<Dish>> getAllDish() {
        return ResponseEntity.ok(dishService.findAll());
    }

    @GetMapping("/{uid}")
    ResponseEntity<Dish> getDishByUid(@PathVariable("uid") String uid) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(dishService.findById(uid));
    }

    @PostMapping
    ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishService.save(dish));
    }

    @PutMapping("/{uid}")
    ResponseEntity<Dish> updateDish(@PathVariable("uid") String uid,
                                    @RequestBody Dish dish) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(dishService.update(uid, dish));
    }

    @DeleteMapping("/{uid}")
    ResponseEntity<Void> deleteDishByUid(@PathVariable("uid") String uid) {
        dishService.deleteById(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
