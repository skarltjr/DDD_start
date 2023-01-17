package com.example.ddd.order.domain.vo;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    public int getValue() {
        return this.value;
    }

    public Money minus(Money discountAmounts) {
        return new Money(this.value - discountAmounts.getValue());
    }
}
