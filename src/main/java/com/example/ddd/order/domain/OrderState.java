package com.example.ddd.order.domain;

public enum OrderState {
    // 결제 완료, 준비중, 출고, 배송중, 배송완료, 취소
    PAYMENT_WAITING, PREPARING, SHIPPED, DELIVERING, DELIVERY_COMPLETED, CANCELED
}
