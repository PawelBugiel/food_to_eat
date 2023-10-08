package com.pawelbugiel.foodToEat.controller;

import com.pawelbugiel.foodToEat.dto.ProductDto;
import com.pawelbugiel.foodToEat.dto.ProductWriteDto;
import com.pawelbugiel.foodToEat.service.ProductService;
import com.pawelbugiel.foodToEat.validators.ObjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ObjectValidator<ProductWriteDto> validator;

    @Autowired
    public ProductController(ProductService productService, ObjectValidator<ProductWriteDto> validator) {
        this.productService = productService;
        this.validator = validator;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/product")
    public ResponseEntity<ProductWriteDto> createProduct(@RequestBody ProductWriteDto productWriteDto) {
        validator.validate(productWriteDto);
        ProductWriteDto tempProductWriteDto = productService.createProduct(productWriteDto);
        return new ResponseEntity<>(tempProductWriteDto, HttpStatus.OK);
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
