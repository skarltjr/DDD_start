package com.example.ddd.catalog.domain.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Option {
    @Column(name = "option_title")
    private String title;

    protected Option(){}
    public Option(String title){
        this.title = title;
    }

}
