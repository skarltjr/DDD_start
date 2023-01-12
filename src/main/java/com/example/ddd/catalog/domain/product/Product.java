package com.example.ddd.catalog.domain.product;

import com.example.ddd.order.domain.vo.Money;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_category",joinColumns = @JoinColumn(name = "product_id"))
    private Set<Long> categories;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private Money price;

    private String detail;


    // 카테고리에 인덱스걸고 카테고리별 검색성능 증진시켜보기
    // 카테고리로 상품 검색시 쿼리힌트줘보기
}
