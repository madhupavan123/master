package com.project.service.impl;

import com.project.dto.ProductDto;
import com.project.entity.Product;
import com.project.repository.ProductRepo;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override

    public String save(ProductDto request) {
     Product product=new Product();
        product.setProductId(request.getProductId());
        product.setProductName(request.getProductName());
//        product.setManufactureDate(request.getManufactureDate());
product.setQuantity(request.getQuantity());
   productRepo.save(product);
        return "Saved Succussfully";
    }

    //
//    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepo.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = new ProductDto();

            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(product.getQuantity());
            productDtoList.add(productDto);

        }
        return productDtoList;
    }





    @Override
    public String saves(ProductDto req) {
        Product product=new Product(req.getProductId(),req.getProductName(),req.getPrice(),req.getQuantity());
        productRepo.save(product);
        return "Saved successfully";
    }

    @Override
    public String deleteId(Long id) {
        productRepo.deleteById(id);
        return "delete successfully";
    }

//    @Override
 public List<ProductDto> getAllProductStartsWithA() {
//        List<Product> productList=productRepo.findAll();
//        List<ProductDto> productDtoList=new ArrayList<>();
//        for (Product p:productList){
//            if(p.getProductName().startsWith("a")||p.getProductName().startsWith("A")){
//                ProductDto productDto=new ProductDto();
//                productDto.setName(p.getProductName());
//                productDto.setId(p.getProductId());
//                productDto.setPrice(p.getPrice());
//                productDto.setQuantity(p.getQuantity());
//                productDtoList.add(productDto);
//            }
//        }
     return null;
//
//    }
 }

    @Override
    public List<ProductDto> getAllProd() {
        List<Product> products=productRepo.findAll();
        List<ProductDto> dtoList=new ArrayList<>();
        for (Product ref:products){
    ProductDto dto=new ProductDto();
        }

        return dtoList;
    }

    @Override
    public String update(Long id, ProductDto req) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()){
            productOptional.get().setProductName(req.getProductName());
            productOptional.get().setPrice(req.getPrice());
            productRepo.save(productOptional.get());
            return "Updated Succesfully";
        }
        return "Given id is not present  "+id;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            productDto.setProductName(productOptional.get().getProductName());
            productDto.setProductId(productOptional.get().getProductId());
            productDto.setPrice(productOptional.get().getPrice());
            productDto.setQuantity(productOptional.get().getQuantity());
            return productDto;
        }
        return new ProductDto();
    }
}

