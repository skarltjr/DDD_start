package com.example.ddd.member.domain;

import com.example.ddd.order.domain.vo.Money;

public enum Grade {
    A(10000),
    B(20000),
    C(30000),
    D(40000);

    private int discountPrice;
    Grade(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getDiscountPrice(){
        return this.discountPrice;
    }
}
