package com.example.ddd.order.domain;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;


    // setter는 지양한다. 생성자로 불변 도모
    // b : 주문할 때 배송지 정보를 반드시 지정해야한다. 생성자에 배송지 정보 필요
    public Order(List<OrderLine> orderLines,ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("주문할 때 배송지 정보를 반드시 지정해야한다.");
        }
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    // b : 최소 한 종류 이상의 상품을 주문해야한다
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("최소 한 종류 이상의 상품을 주문해야한다.");
        }
    }

    // b : 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다
    private void calculateTotalAmounts() {
        int sum = orderLines.stream().mapToInt(orderLine -> orderLine.getAmounts()).sum();
        this.totalAmounts = new Money(sum);
    }

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(shippingInfo);
    }

    // b : 출고전에 주문을 취소할 수 있다.
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    // b : 출고를 하면 배송지를 변경할 수 없다.
    private void verifyNotYetShipped() {
        if (this.state != OrderState.PAYMENT_WAITING && this.state != OrderState.PREPARING) {
            throw new IllegalArgumentException("출고를 하면 배송지를 변경할 수 없다.");
        }
    }

}

/**
 * 비즈니스 요구 사항
 * 최소 한 종류 이상의 상품을 주문해야한다
 * 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다
 * 한 상품을 한 개 이상 주문할 수 있다.
 * 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다
 * 주문할 때 배송지 정보를 반드시 지정해야한다.
 * 배송지 정보는 받는 사람 이름, 번호, 주소로 구성된다.
 * 출고를 하면 배송지를 변경할 수 없다.
 * 출고전에 주문을 취소할 수 있다.
 * 고객이 결제를 완료하기 전에는 상품을 준비하지 않는다.
 * */