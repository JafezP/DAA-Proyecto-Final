package com.institute.order.infrastructure.adapter.dish;

import com.institute.order.domain.model.dish.Dish;
import com.institute.order.domain.model.dish.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DishAdapter implements DishRepository {

    private final DishDataRepository dishDataRepository;

    @Override
    public List<Dish> findAll() {
        return dishDataRepository.findAll()
                .stream()
                .map(DishMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public Dish findById(String id) {
        Optional<DishData> dishOptional = dishDataRepository.findById(id);
        return dishOptional.map(DishMapper.MAPPER::toModel).orElse(null);
    }

    @Override
    public Dish save(Dish dish) {
        DishData dishData = DishMapper.MAPPER.toData(dish);
        return DishMapper.MAPPER.toModel(dishDataRepository.save(dishData));
    }
}
