package com.example.ddd.catalog.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class CatalogRequest {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateCategory{
        @NotBlank(message = "유효하지 않은 상품 이름입니다. 상품이름을 다시 확인해주세요.")
        private String name;

        public CreateCategory(String name) {
            this.name = name;
        }
    }
}
