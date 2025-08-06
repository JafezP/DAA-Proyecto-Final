package com.institute.chef.infrastructure.adapter;

import com.institute.chef.domain.model.Chef;
import com.institute.chef.domain.model.ChefRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChefAdapter implements ChefRepository {

    private final ChefDataRepository chefDataRepository;

    @Override
    public List<Chef> findAll() {
        return chefDataRepository.findAll()
                .stream()
                .filter(chefData -> chefData.getActive() != 0)
                .map(ChefMapper.MAPPER::toModel)
                .toList();
    }

   @Override
    public Chef findById(String uid) {
        return chefDataRepository.findById(uid)
                .filter(chefData -> chefData.getActive() == 1)
                .map(ChefMapper.MAPPER::toModel)
                .orElseThrow(() -> new EntityNotFoundException("Chef not found or inactive: " + uid));
    }

    @Override
    public Chef save(Chef chef) {
        ChefData chefData = chefDataRepository.save(ChefMapper.MAPPER.toEntity(chef));
        return ChefMapper.MAPPER.toModel(chefData);
    }

    @Override
    public Chef update(String uid, Chef chef) {
        ChefData existing = chefDataRepository.findById(uid)
                .orElseThrow(() -> new EntityNotFoundException("Chef not found: " + uid));

        ChefData update = ChefMapper.MAPPER.toEntity(chef);
        update.setUid(existing.getUid());
        return ChefMapper.MAPPER.toModel(chefDataRepository.save(update));
    }

    @Override
    public void deleteById(String uid) {
        chefDataRepository.findById(uid)
                .filter(c -> c.getActive() == 1)
                .ifPresent(chefData -> {
                    chefData.setActive(0);
                    chefDataRepository.save(chefData);
                });

    }
}
