package com.institute.chef.domain.service;

import com.institute.chef.domain.model.Chef;
import com.institute.chef.domain.model.ChefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChefServiceImpl implements ChefService{

    private final ChefRepository chefRepository;

    @Override
    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(String uid) {
        return chefRepository.findById(uid);
    }

    @Override
    public Chef save(Chef chef) {
        return chefRepository.save(chef);
    }

    @Override
    public Chef update(String uid, Chef chef) {
        return chefRepository.update(uid, chef);
    }

    @Override
    public void deleteById(String uid) {
        chefRepository.deleteById(uid);
    }
}
