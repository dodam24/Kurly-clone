package com.example.market.controller;

import com.example.market.domain.Cart;
import com.example.market.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartController {
    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping(value = {"/api/v1/cart/{uid}/{pid}"})
    public String createCart(@PathVariable Long uid,
                             @PathVariable Long pid
    ){
        Cart cart = cartService.createCart(uid,pid);
        return "success";
    }
    @GetMapping("/api/v1/cart/{uid}")
    public List<Cart> getCartList(@PathVariable Long uid){
        System.out.println("cart list check");
        return cartService.getCartList(uid);
    }
    @DeleteMapping("/api/v1/cart/{cid}")
    public String deleteCart(@PathVariable Long cid){
        return cartService.deleteCart(cid);
    }
}