package com.example.market.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="cart")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }
}