package com.pawelbugiel.foodToEat.service;

import com.pawelbugiel.foodToEat.dto.ProductDto;
import com.pawelbugiel.foodToEat.dto.ProductWriteDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

//************** CREATE *************

    ProductWriteDto createProduct(ProductWriteDto productWriteDto);

//************** FIND *************

    List<ProductDto> findAllProducts(String page, Sort.Direction sort);

    ProductDto findProductById(String id);

    List<ProductDto> findProductsByPartialName(String partialName, String page, Sort.Direction sort);

    List<ProductDto> findProductsWithExpiredDate(String page, Sort.Direction sort);

//************** UPDATE *************

    ProductDto updateProduct(ProductDto productDto);

//************** DELETE *************

    ProductDto deleteProductById(String id);

}
