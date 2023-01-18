package com.example.ddd.catalog.domain.product;

import com.example.ddd.catalog.ErrorCodes;
import com.example.ddd.common.jpa.MoneyConverter;
import com.example.ddd.order.domain.vo.Money;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    @Convert(converter = MoneyConverter.class)
    private Money price;

    @Column(name = "product_detail")
    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
        orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Image> images;

    @Column(name = "product_register_date")
    private LocalDateTime registerDate;

    protected Product(){}
    public Product(Set<Long> categories,String name,Money price,String detail,
                   List<Image> images){
        setCategories(categories);
        setImages(images);
        this.price = price;
        this.name = name;
        this.detail = detail;
        this.registerDate = LocalDateTime.now();
    }
    public Long getId(){
        return this.id;
    }
    private void setImages(List<Image> images) {
        if (images.isEmpty() || images == null){
            throw new IllegalArgumentException(ErrorCodes.IMAGE_NOT_EXIST);
        }
        this.images = images;
    }

    private void setCategories(Set<Long> categories) {
        if (categories.isEmpty() || categories == null){
            throw new IllegalArgumentException(ErrorCodes.NOT_VALID_PRODUCT_CATEGORIES);
        }
        this.categories = categories;
    }

    public Money getPrice() {
        return price;
    }

    // 카테고리에 인덱스걸고 카테고리별 검색성능 증진시켜보기
    // 카테고리로 상품 검색시 쿼리힌트줘보기
}
