package com.example.ddd.order.domain;

public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, int price, int quantity, int amounts) {
        this.product = product;
        this.price = new Money(price);
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    public Money getAmounts() {
        return this.amounts;
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }


}

/**
 * 비즈니스 요구 사항
 * 한 상품을 한 개 이상 주문할 수 있다.
 * 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다
 * */
