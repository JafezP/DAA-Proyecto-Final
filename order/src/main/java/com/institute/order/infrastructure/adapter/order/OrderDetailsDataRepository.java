package com.institute.order.infrastructure.adapter.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsDataRepository extends JpaRepository<OrderDetailsData, String> {
    
    List<OrderDetailsData> findByUidOrder(String uidOrder);
    
    List<OrderDetailsData> findByUidCustomer(String uidCustomer);
}
