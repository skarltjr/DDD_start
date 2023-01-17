package com.example.ddd.catalog.presentation;

import com.example.ddd.catalog.application.CategoryService;
import com.example.ddd.catalog.application.dto.CatalogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CatalogRequest.CreateCategory req) {
        Long categoryId = categoryService.create(req.getName());
        return ResponseEntity.ok().body(categoryId);
    }
}
