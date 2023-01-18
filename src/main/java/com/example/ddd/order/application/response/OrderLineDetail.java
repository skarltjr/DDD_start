package com.example.ddd.order.application.response;

import com.example.ddd.order.domain.OrderLine;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderLineDetail {
    private Long productId;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLineDetail(OrderLine orderLine) {
        this.productId = orderLine.getProductId();
        this.price = orderLine.getPrice().getValue();
        this.quantity = orderLine.getQuantity();
        this.amounts = orderLine.getAmounts().getValue();
    }

}
