package com.example.ddd.catalog.application.dto;

import com.example.ddd.catalog.domain.product.Image;
import com.example.ddd.order.domain.vo.Money;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

public class ProductRequest {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateProduct{
        @NotBlank(message = "유효하지 않은 상품 이름입니다. 상품이름을 다시 확인해주세요.")
        private String name;

        @NotEmpty(message = "유효하지 않은 카테고리입니다.")
        private Set<Long> categories;
        @NotBlank(message = "유효하지 않은 가격입니다.")
        private Money price;
        @NotBlank(message = "유효하지 않은 설명입니다.")
        private String detail;

        @NotEmpty(message = "유효하지 않은 이미지입니다.")
        private List<Image> images;
        public CreateProduct(String name, Set<Long> categories,
                             Money price, String detail,List<Image> images) {
            this.name = name;
            this.categories.addAll(categories);
            this.price = price;
            this.detail = detail;
            this.images.addAll(images);
        }
    }
}
