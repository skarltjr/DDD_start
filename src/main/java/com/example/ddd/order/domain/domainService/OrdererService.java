package com.example.ddd.order.domain.domainService;

import com.example.ddd.order.domain.Orderer;

public interface OrdererService {
    Orderer createOrderer(Long memberId);
}
