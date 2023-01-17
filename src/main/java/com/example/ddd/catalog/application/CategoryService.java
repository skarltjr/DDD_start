package com.example.ddd.catalog.application;

import com.example.ddd.catalog.ErrorCodes;
import com.example.ddd.catalog.domain.category.Category;
import com.example.ddd.catalog.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Long create(String name) {
        checkCategoryNameIfAlreadyExist(name);
        Category category = categoryRepository.save(new Category(name));
        return category.getId();
    }

    private void checkCategoryNameIfAlreadyExist(String name) {
        if (categoryRepository.existsByName(name)){
            throw new IllegalArgumentException(ErrorCodes.ALREADY_EXIST_CATEGORY);
        }
    }
}
