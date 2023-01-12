package com.example.ddd.member.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Grade {
    @Column(name = "grade")
    private String value;

    protected Grade(){}
    public Grade(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
