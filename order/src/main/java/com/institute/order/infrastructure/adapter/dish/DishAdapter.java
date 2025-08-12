package com.institute.order.infrastructure.adapter.dish;

import com.institute.order.domain.model.dish.Dish;
import com.institute.order.domain.model.dish.DishRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DishAdapter implements DishRepository {

    private final DishDataRepository dishDataRepository;

    @Override
    public List<Dish> findAll() {
        return dishDataRepository.findAll()
                .stream()
                .filter(dishData -> dishData.getActive() != 0)
                .map(DishMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Dish findById(String uid) {
        return dishDataRepository.findById(uid)
                .filter(dishData -> dishData.getActive() == 1)
                .map(DishMapper.MAPPER::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found or inactive: " + uid));
    }

    @Override
    public Dish save(Dish dish) {
        DishData dishData = dishDataRepository.save(DishMapper.MAPPER.toEntity(dish));
        return DishMapper.MAPPER.toDomain(dishData);
    }

    @Override
    public Dish update(String uid, Dish dish) {
        DishData currentDishData = dishDataRepository.findById(uid)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found or inactive: " + uid));

        DishData updatedDishData = DishMapper.MAPPER.toEntity(dish);
        updatedDishData.setUid(currentDishData.getUid());
        return DishMapper.MAPPER.toDomain(dishDataRepository.save(updatedDishData));
    }

    @Override
    public void deleteById(String uid) {
        dishDataRepository.findById(uid)
                .filter(dishData -> dishData.getActive() == 1)
                .ifPresent(dishData -> {
                    dishData.setActive(0);
                    dishDataRepository.save(dishData);
                });
    }
}
