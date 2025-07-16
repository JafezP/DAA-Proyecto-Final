package com.institute.Chef.domain.model;

import java.util.List;

public interface ChefRepository {
    List<Chef> findAll();
    Chef findById(String uid);
    Chef save(Chef chef);
    Chef update(String uid, Chef chef);
    void deleteById(String uid);





}
