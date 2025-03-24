package com.bavung.javaMVC.Service;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Repository.CartRepository;

@Service
public class CartService {
    private CartRepository cartRepository;
    public CartService(CartRepository cartRepository)
    {
        this.cartRepository = cartRepository;
    }
    public Cart findByUser(User user)
    {
        return this.cartRepository.findByUser(user);
    }
    public Cart SaveCart(Cart cart){
        return this.cartRepository.save(cart);
    }
}
