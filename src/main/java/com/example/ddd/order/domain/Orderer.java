package com.example.ddd.order.domain;

import com.example.ddd.member.domain.Grade;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
public class Orderer {

    private Long ordererId;
    @Column(name = "orderer_name")
    private String name;

    @Column(name = "orderer_grade")
    private Grade grade;

    protected Orderer(){
    }

    public Orderer(Long memberId,String name,Grade grade){
        this.ordererId = memberId;
        this.name = name;
        this.grade = grade;
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
