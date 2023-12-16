package com.example.market.dto.respones;

import com.example.market.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDetailRes {

    private Long productId;
    private String productName;
    private String productImg;
    private String price;
    private String description;
    private String country;
    private String amount;
    private String unit;
    private String delivery;
    private String packing;
    private String keeping;
    private String information;

@Builder
public ProductDetailRes(Long productId, String productName, String productImg, String price, String description, String country, String information, String amount, String unit, String delivery, String packing, String keeping) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.price = price;
        this.description = description;
        this.country = country;
        this.information = information;
        this.amount = amount;
        this.unit = unit;
        this.delivery = delivery;
        this.packing = packing;
        this.keeping = keeping;

        }
public static ProductDetailRes of(Product product){
        return ProductDetailRes.builder()
        .productId(product.getId())
        .productName(product.getProductName())
        .productImg(product.getProductImg())
        .price(product.getPrice())
        .description(product.getDescription())
        .country(product.getCountry())
        .information(product.getInformation())
        .amount(product.getAmount())
        .unit(product.getUnit())
        .delivery(product.getDelivery())
        .packing(product.getPacking())
        .keeping(product.getKeeping()).build();
        }
        }
