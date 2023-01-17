package com.example.ddd.order.application.response;

import com.example.ddd.order.domain.Order;
import com.example.ddd.order.domain.OrderState;
import com.example.ddd.order.domain.Orderer;
import com.example.ddd.order.domain.vo.ShippingInfo;

import java.util.List;

public class Response {
    public static class CreateOrder{
        private Long orderId;
        private List<OrderLineDetail> orderLineDetails;

        private Orderer orderer;
        private ShippingInfo shippingInfo;
        private OrderState state;
        private int totalAmounts;
    }
}
