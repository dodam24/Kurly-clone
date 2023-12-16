package com.example.market.service;

import com.example.market.domain.*;
import com.example.market.repository.CartRepositroy;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepositroy cartRepositroy;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    public CartService(CartRepositroy cartRepositroy,UserRepository userRepository,ProductRepository productRepository) {
        this.cartRepositroy = cartRepositroy;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    public Cart createCart(Long uid,Long pid){
        /* user 한번 더 확인*/
        User user = userRepository.findById(uid).orElseThrow(
                ()-> new IllegalArgumentException("userError")
        );
        /* 해당 상품이 존재하는지 확인. */
        Product product =productRepository.findById(pid).orElseThrow(
                ()-> new IllegalArgumentException("productError")
        );
        System.out.println(product);
        System.out.println(user);
        Cart cart = new Cart(product,user);
        cartRepositroy.save(cart);
        return cart;
    }
    public List<Cart> getCartList(Long uid){
        User user = userRepository.findById(uid).orElseThrow(
                ()-> new IllegalArgumentException("userError")
        );
        return cartRepositroy.findByUser(user);
    }
    public String deleteCart(Long cid){
        /* 해당 cart가 존재하는지 확인 */
        try{
            Optional<Cart> cart=cartRepositroy.findById(cid);
        }catch (IllegalArgumentException e){
            return "false";
        }
        cartRepositroy.deleteById(cid);
        return "true";
    }
}