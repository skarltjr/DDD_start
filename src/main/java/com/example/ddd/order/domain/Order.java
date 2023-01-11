package com.example.ddd.order.domain;

import com.example.ddd.order.ErrorCodes;
import com.example.ddd.order.domain.vo.Money;
import com.example.ddd.order.domain.vo.ShippingInfo;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 주문자
    @Embedded
    private Orderer orderer;

    // orderlines
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line",joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderLine> orderLines;

    // 배송지
    @Embedded
    private ShippingInfo shippingInfo;

    // 총 금액
    @Column(name = "total_amounts")
    private Money totalAmounts;

    // orderState
    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    // orderDate
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    protected Order(){}
    public Order(Orderer orderer,ShippingInfo shippingInfo,OrderState state,
                 List<OrderLine> orderLines){
        setOrderer(orderer);
        setShippingInfo(shippingInfo);
        setOrderLines(orderLines);
        this.state = state;
        this.orderDate = LocalDateTime.now();
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateAmounts();
    }

    private void calculateAmounts() {
        int sum = orderLines.stream().mapToInt(orderLine
                -> orderLine.getAmounts().getValue()).sum();
        this.totalAmounts = new Money(sum);
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines.isEmpty() || orderLines == null){
            throw new IllegalArgumentException(ErrorCodes.NOT_VALID_ORDER_LINES);
        }
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null){
            throw new IllegalArgumentException(ErrorCodes.NOT_VALID_SHIPPING_INFO);
        }
        this.shippingInfo = shippingInfo;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null){
            throw new IllegalArgumentException(ErrorCodes.NOT_VALID_ORDERER);
        }
        this.orderer = orderer;
    }

    // 배송지 변경
    public void changeShippingInfo(ShippingInfo shippingInfo){
        verifyNotYetShipped();
        setShippingInfo(shippingInfo);
    }

    private void verifyNotYetShipped() {
        if (this.state != OrderState.PREPARING && this.state != OrderState.PAYMENT_WAITING){
            throw new IllegalArgumentException(ErrorCodes.CAN_NOT_CHANGE_SHIPPING_INFO);
        }
    }

    // 주문 취소
    public void cancel(){
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }
}

/**
 * 비즈니스 요구 사항
 * 최소 한 종류 이상의 상품을 주문해야한다
 *  -> 주문시 orderline empty 확인
 *
 * 총 주문 금액은 각 상품의 구매 가격 합을 모두 더한 금액이다
 *  -> 각 제품 주문은 orderline이며 orderline에 각 제품 수량 및 총 가격등 정보 필요
 *
 * 한 상품을 한 개 이상 주문할 수 있다.
 *
 * 각 상품의 구매 가격 합은 상품 가격에 구매 개수를 곱한 값이다
 *  -> orderline에서 각 제품주문 총합 필요
 *
 * 주문할 때 배송지 정보를 반드시 지정해야한다.
 *  -> shippingInfo를 생성자에서 다룬다
 *
 * 배송지 정보는 받는 사람 이름, 번호, 주소로 구성된다.
 *
 * 출고를 하면 배송지를 변경할 수 없다.
 *
 * 출고전에 주문을 취소할 수 있다.
 *
 * 고객이 결제를 완료하기 전에는 상품을 준비하지 않는다.
 * */