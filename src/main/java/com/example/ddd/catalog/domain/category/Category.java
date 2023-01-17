package com.example.ddd.catalog.domain.category;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    protected Category(){}

    public Category(String name){
        this.name = name;
    }
    public Long getId(){
        return this.id;
    }
}
