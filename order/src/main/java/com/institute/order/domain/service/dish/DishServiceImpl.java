package com.institute.order.domain.service.dish;

import com.institute.order.domain.model.dish.Dish;
import com.institute.order.domain.model.dish.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(String uid) {
        return dishRepository.findById(uid);
    }

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish update(String uid, Dish dish) {
        return dishRepository.update(uid, dish);
    }

    @Override
    public void deleteById(String uid) {
        dishRepository.deleteById(uid);
    }
}
