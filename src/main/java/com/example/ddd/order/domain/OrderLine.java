package com.example.ddd.order.domain;

public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity, int amounts) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private int calculateAmounts() {
        return price * quantity;
    }

}

/**
 * 비즈니스 요구 사항
 * 한 상품을 한 개 이상 주문할 수 있다.
 * 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다
 * */
