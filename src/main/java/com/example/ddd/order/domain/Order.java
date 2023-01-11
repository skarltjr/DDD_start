package com.example.ddd.order.domain;

import com.example.ddd.order.domain.vo.Money;
import com.example.ddd.order.domain.vo.ShippingInfo;

import java.util.ArrayList;
import java.util.List;

public class Order {

}

/**
 * 비즈니스 요구 사항
 * 최소 한 종류 이상의 상품을 주문해야한다
 *  -> 주문시 orderline empty 확인
 * 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다
 *  -> 각 제품 주문은 orderline이며 orderline에 각 제품 수량 및 총 가격등 정보 필요
 * 한 상품을 한 개 이상 주문할 수 있다.
 * 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다
 *  -> orderline에서 각 제품주문 총합 필요
 * 주문할 때 배송지 정보를 반드시 지정해야한다.
 *  -> shippingInfo를 생성자에서 다룬다
 * 배송지 정보는 받는 사람 이름, 번호, 주소로 구성된다.
 * 출고를 하면 배송지를 변경할 수 없다.
 * 출고전에 주문을 취소할 수 있다.
 * 고객이 결제를 완료하기 전에는 상품을 준비하지 않는다.
 * */