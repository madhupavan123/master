package com.project.controller;

import com.project.dto.ProductDto;
import com.project.entity.Product;
import com.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save-product")
    public String saveProduct(@RequestBody ProductDto request){
return productService.save(request);

    }
    @GetMapping("/getProductDetails")
    public List<ProductDto> getAllProduct(){

        return productService.getAllProduct();
    }
    @GetMapping("/getAllProducts")
    public List<ProductDto> getAllPro(){
        return productService.getAllProduct();
    }
    @GetMapping("/getAllProductsStartWithA")
    public List<ProductDto> getAllProductsStartWithA(){
        return productService.getAllProductStartsWithA();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteId(@PathVariable("id") Long id){
        return productService.deleteId(id);
    }
    @PutMapping("/update/{id}")
    public String updateName(@PathVariable("id") Long id,@RequestBody ProductDto req){
        return productService.update(id,req);

    }
    @GetMapping("/getProductById/{id}")
    public ProductDto getById(@PathVariable("id")Long id){
        return productService.getProductById(id);
    }
    @PatchMapping("/update")
    public String updateNameWithPatch(@RequestParam("id") Long id,@RequestBody ProductDto req){
        return productService.update(id,req);

    }
}
