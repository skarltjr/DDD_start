package com.example.ddd.catalog.presentation;

import com.example.ddd.catalog.application.ProductService;
import com.example.ddd.catalog.application.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProductRequest.CreateProduct req){
        Long productId = productService.create(req);
        return ResponseEntity.ok().body(productId);
    }
}
