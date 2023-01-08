package com.example.ddd.order.domain;

import com.example.ddd.order.domain.vo.Money;

public class OrderLine {
    private Product product;
    private int quantity;
    private Money price;
    private Money amounts;

    public OrderLine(Product product, int quantity, Money price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return this.price.multiply(quantity);
    }

    public Money getAmounts() {
        return this.amounts;
    }
}

/**
 * 비즈니스 요구 사항
 * 한 상품을 한 개 이상 주문할 수 있다.
 * 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다
 * */
