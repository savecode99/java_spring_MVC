package com.bavung.javaMVC.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Repository.CartDetailRepository;

@Service
public class CartDetailService {
    private CartDetailRepository cartDetailRepository;
    public CartDetailService(CartDetailRepository cartDetailRepository)
    {
        this.cartDetailRepository = cartDetailRepository;
    }
    public List<CartDetail> findByCart(Cart cart)
    {   
        return this.cartDetailRepository.findByCart(cart);
    }
}
