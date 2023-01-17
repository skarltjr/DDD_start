package com.example.ddd.order.domain.domainService;

import com.example.ddd.member.domain.Grade;
import com.example.ddd.order.domain.OrderLine;
import com.example.ddd.order.domain.vo.Money;
import org.springframework.stereotype.Component;

import java.util.List;


public interface DiscountCalculationService {
    public Money calculateDiscountAmounts(Grade grade);
}
