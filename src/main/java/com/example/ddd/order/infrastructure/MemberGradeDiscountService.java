package com.example.ddd.order.infrastructure;

import com.example.ddd.member.domain.Grade;
import com.example.ddd.order.domain.domainService.DiscountCalculationService;
import com.example.ddd.order.domain.vo.Money;
import org.springframework.stereotype.Component;

@Component
public class MemberGradeDiscountService implements DiscountCalculationService {
    @Override
    public Money calculateDiscountAmounts(Grade grade) {
        return new Money(grade.getDiscountPrice());
    }
}
