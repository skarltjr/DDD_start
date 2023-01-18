package com.example.ddd.order.domain.domainService;

import com.example.ddd.member.domain.Grade;
import com.example.ddd.order.domain.vo.Money;



public interface DiscountCalculationService {
    public Money calculateDiscountAmounts(Grade grade);
}
