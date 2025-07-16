package com.institute.Chef.domain.service;

import com.institute.Chef.domain.model.Chef;

import java.util.List;

public interface ChefService {
    List<Chef> findAll();
    Chef findById(String uid);
    Chef save(Chef chef);
    Chef update(String uid, Chef chef);
    void deleteById(String uid);
}
