package com.example.ddd.catalog.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Password{
    @Column(name = "password",nullable = false)
    private String value;

    public Password(String value) {
        this.value = value;
    }

    protected Password() {
    }

    public String getValue(){
        return this.value;
    }
    public boolean match(String password) {
        return this.value.equals(password);
    }
}
