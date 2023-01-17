package com.example.ddd.order.application.request;

import com.example.ddd.order.domain.vo.ShippingInfo;

import java.util.List;

public class Request {
    public static class createOrder{
        private List<OrderProduct> products;
        private Long memberId;
        private ShippingInfo shippingInfo;

        public List<OrderProduct> getProducts() {
            return products;
        }

        public Long getMemberId() {
            return memberId;
        }

        public ShippingInfo getShippingInfo() {
            return shippingInfo;
        }
    }
}
