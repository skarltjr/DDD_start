package com.example.ddd.order.domain;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;


}

/**
 * 비즈니스 요구 사항
 * 최소 한 종류 이상의 상품을 주문해야한다
 * 한 상품을 한 개 이상 주문할 수 있다.
 * 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다
 * 주문할 때 배송지 정보를 반드시 지정해야한다.
 * 배송지 정보는 받는 사람 이름, 번호, 주소로 구성된다.
 * 출고를 하면 배송지를 변경할 수 없다.
 * 출고전에 주문을 취소할 수 있다.
 * 고객이 결제를 완료하기 전에는 상품을 준비하지 않는다.
 * */