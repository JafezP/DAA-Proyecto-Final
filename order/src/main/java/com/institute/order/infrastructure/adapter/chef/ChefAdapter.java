package com.institute.order.infrastructure.adapter.chef;

import com.institute.order.domain.model.chef.Chef;
import com.institute.order.domain.model.chef.ChefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ChefAdapter implements ChefRepository {

    private final RestTemplate restTemplate;

    @Override
    public Chef findById(String uid) {
        String url = "http://localhost:8084/api/v1/institute/chef/" + uid;
        ChefData chefData = restTemplate.getForObject(url, ChefData.class);
        return ChefMapper.MAPPER.toDomain(chefData);
    }
}
