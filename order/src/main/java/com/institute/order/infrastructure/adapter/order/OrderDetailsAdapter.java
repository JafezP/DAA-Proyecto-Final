package com.institute.order.infrastructure.adapter.order;

import com.institute.order.domain.model.order.OrderDetails;
import com.institute.order.domain.model.order.OrderDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDetailsAdapter implements OrderDetailsRepository {

    private final OrderDetailsDataRepository orderDetailsDataRepository;

    @Override
    public List<OrderDetails> findByOrderId(String uidOrder) {
        return orderDetailsDataRepository.findByUidOrder(uidOrder)
                .stream()
                .map(OrderDetailsMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public List<OrderDetails> findByCustomerId(String uidCustomer) {
        return orderDetailsDataRepository.findByUidCustomer(uidCustomer)
                .stream()
                .map(OrderDetailsMapper.MAPPER::toModel)
                .toList();
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        OrderDetailsData data  = OrderDetailsMapper.MAPPER.toData(orderDetails);
        return OrderDetailsMapper.MAPPER
                .toModel(orderDetailsDataRepository.save(data));
    }
}
