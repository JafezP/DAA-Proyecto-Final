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
                .map(ChefMapper.MAPPER::toDomain)
                .toList();
    }

    @Override
    public Chef findById(String uid) {
        return chefDataRepository.findById(uid)
                .filter(chefData -> chefData.getActive() == 1)
                .map(ChefMapper.MAPPER::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Chef not found or inactive: " + uid));
    }

    @Override
    public Chef save(Chef chef) {
        ChefData chefData = chefDataRepository.save(ChefMapper.MAPPER.toEntity(chef));
        return ChefMapper.MAPPER.toDomain(chefData);
    }

    @Override
    public Chef update(String uid, Chef chef) {
        ChefData currentChefData = chefDataRepository.findById(uid)
                .orElseThrow(() -> new EntityNotFoundException("Chef not found or inactive: " + uid));

        ChefData updatedChefData = ChefMapper.MAPPER.toEntity(chef);
        updatedChefData.setUid(currentChefData.getUid());
        return ChefMapper.MAPPER.toDomain(chefDataRepository.save(updatedChefData));
    }

    @Override
    public void deleteById(String uid) {
        chefDataRepository.findById(uid)
                .filter(chefData -> chefData.getActive() == 1)
                .ifPresent(chefData -> {
                    chefData.setActive(0);
                    chefDataRepository.save(chefData);
                });
    }
}
