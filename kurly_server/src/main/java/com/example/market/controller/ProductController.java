package com.example.market.controller;

import com.example.market.dto.respones.ProductDetailRes;
import com.example.market.dto.respones.ProductSimpleRes;
import com.example.market.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/main")
    public ResponseEntity<List<ProductSimpleRes>> findSimpleProduct(){
        return ResponseEntity.ok().body(productService.findSimpleProduct());
    }

    @GetMapping("/market/products/{productId}")
    public ResponseEntity<ProductDetailRes> findDetailProduct(@PathVariable(name = "productId") Long id){
        return ResponseEntity.ok().body(productService.findDetailProduct(id));
    }


}