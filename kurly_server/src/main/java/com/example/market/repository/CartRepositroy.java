package com.example.market.repository;

import com.example.market.domain.Cart;
import com.example.market.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepositroy extends JpaRepository<Cart,Long> {
    List<Cart> findByUser(User user);
}