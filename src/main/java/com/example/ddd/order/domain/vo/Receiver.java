package com.example.ddd.order.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Receiver {
    @Column(name = "receiver_name")
    private String name;
    @Column(name = "receiver_phone")
    private String phone;

    public Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

