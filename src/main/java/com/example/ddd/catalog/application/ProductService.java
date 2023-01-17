package com.example.ddd.catalog.application;


import com.example.ddd.catalog.ErrorCodes;
import com.example.ddd.catalog.application.dto.ProductRequest;
import com.example.ddd.catalog.domain.category.CategoryRepository;
import com.example.ddd.catalog.domain.product.Product;
import com.example.ddd.catalog.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Long create(ProductRequest.CreateProduct req) {
        req.getCategories().stream().forEach(category -> checkIfExistCategory(category));
        Product product = new Product(req.getCategories(),
                req.getName(),
                req.getPrice(),
                req.getDetail(),
                req.getImages()
        );
        return productRepository.save(product).getId();
    }

    private void checkIfExistCategory(Long category) {
        if (!categoryRepository.existsById(category)) {
            throw new IllegalArgumentException(ErrorCodes.NOT_VALID_PRODUCT_CATEGORIES);
        }
    }
}
