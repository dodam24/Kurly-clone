package com.example.market.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long Id;
//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
    @Column(nullable = false)
    private String productImg;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String information;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String amount;
    @Column(nullable = false)
    private String unit;
    @Column(nullable = false)
    private String delivery;
    @Column(nullable = false)
    private String packing;
    @Column(nullable = false)
    private String expiryDate;
    @Column(nullable = false)
    private String keeping;

}
