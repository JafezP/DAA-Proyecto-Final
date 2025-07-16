package com.institute.Chef.domain.service;


import com.institute.Chef.domain.model.Chef;
import com.institute.Chef.domain.model.ChefRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChefServiceImpl implements ChefService{


    private final ChefRepository chefRepository;

    @Override
    public List<Chef> findAll() { return chefRepository.findAll(); }

    @Override
    public Chef findById(String uid) { return chefRepository.findById(uid); }

    @Override
    public Chef save(Chef chef) { return chefRepository.save(chef); }

    @Override
    public Chef update(String uid, Chef chef) { return chefRepository.update(uid, chef); }

    @Override
    public void deleteById(String uid) { chefRepository.deleteById(uid); }
}
