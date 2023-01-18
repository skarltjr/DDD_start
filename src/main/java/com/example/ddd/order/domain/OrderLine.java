package com.example.ddd.order.domain;

import com.example.ddd.common.jpa.MoneyConverter;
import com.example.ddd.order.domain.vo.Money;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
public class OrderLine {
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "price")
    @Convert(converter = MoneyConverter.class)
    private Money price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amounts")
    @Convert(converter = MoneyConverter.class)
    private Money amounts;

    protected OrderLine(){}

    public OrderLine(Long productId,int quantity,Money price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public Money getAmounts(){
        return this.amounts;
    }

    public Long getProductId() {
        return productId;
    }

    public Money getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
