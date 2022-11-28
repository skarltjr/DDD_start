package com.example.ddd.order.domain;

public class ShippingInfo {
    private Address address;
    private Receiver receiver;
    private String message;

    public ShippingInfo(Address address, Receiver receiver, String message) {
        this.address = address;
        this.receiver = receiver;
        this.message = message;
    }
}
