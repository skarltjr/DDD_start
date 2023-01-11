package com.example.ddd.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Orderer {

    private Long ordererId;
    @Column(name = "orderer_name")
    private String name;

    protected Orderer(){
    }

    public Orderer(Long memberId,String name){
        this.ordererId = memberId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderer orderer = (Orderer) o;
        return Objects.equals(ordererId, orderer.ordererId) && Objects.equals(name, orderer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordererId, name);
    }
}
