package com.example.market.dto.respones;

import com.example.market.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductSimpleRes {

    private Long productId;
    private String productName;
    private String productImg;
    private String price;
    private String description;

    @Builder
    public ProductSimpleRes(Long productId, String productName, String productImg, String price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.price = price;
        this.description = description;
    }
    public static ProductSimpleRes of(Product product){
        return ProductSimpleRes.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .productImg(product.getProductImg())
                .price(product.getPrice())
                .description(product.getDescription()).build();
    }
    public static List<ProductSimpleRes> list(List<Product> products){
        ArrayList<ProductSimpleRes> simpleResArrays = new ArrayList<>();
        for (Product product: products){
            simpleResArrays.add(of(product));

        }
        return simpleResArrays;
    }
}
