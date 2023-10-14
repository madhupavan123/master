package com.project.service;

import com.project.dto.ProductDto;
import com.project.entity.Product;

import java.util.List;

public interface ProductService {
    public String save(ProductDto request);

    List<ProductDto> getAllProduct();
    public  String saves(ProductDto req);

    String deleteId(Long id);
    public List<ProductDto> getAllProductStartsWithA();
    List<ProductDto> getAllProd();

    String update(Long id, ProductDto req);
    public ProductDto getProductById(Long id);
}

