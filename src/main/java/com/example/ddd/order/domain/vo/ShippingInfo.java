package com.example.ddd.order.domain.vo;

import com.example.ddd.order.domain.vo.Address;
import com.example.ddd.order.domain.vo.Receiver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfo {
    @Embedded
    private Address address;
    @Embedded
    private Receiver receiver;
    private String message;
}
