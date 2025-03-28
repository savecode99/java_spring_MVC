package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Repository.CartDetailRepository;
import com.bavung.javaMVC.Repository.CartRepository;
import com.bavung.javaMVC.Repository.ProductRepo;

@Service
public class CartDetailService {
    private CartDetailRepository cartDetailRepository;
    private ProductRepo productRepo;
    private CartRepository cartRepository;
    public CartDetailService(CartDetailRepository cartDetailRepository , ProductRepo productRepo , CartRepository cartRepository)
    {
        this.cartDetailRepository = cartDetailRepository;
        this.productRepo = productRepo;
        this.cartRepository = cartRepository;
    }
    public List<CartDetail> findByCart(Cart cart)
    {   
        return this.cartDetailRepository.findByCart(cart);
    }
    public void deleteByProductAndCart(Product product , Cart cart){
        this.cartDetailRepository.deleteByProductAndCart(product, cart);
    }
    
    public void IncreaseQuantity(long productId , long cartId ){
        Optional<Product> res = this.productRepo.findById(productId);
        if(!res.isEmpty()){
            CartDetail cartDetail = this.cartDetailRepository.findByCartAndProduct(this.cartRepository.findById(cartId) , res.get());
            long new_quan = cartDetail.getQuantity() + 1;
            cartDetail.setQuantity(new_quan);
            this.cartDetailRepository.save(cartDetail);
        }
       
    }
    public void DecreaseQuantity(long productId , long cartId ){
        Optional<Product> res = this.productRepo.findById(productId);
        if(!res.isEmpty()){
            CartDetail cartDetail = this.cartDetailRepository.findByCartAndProduct(this.cartRepository.findById(cartId) , res.get());
            
            if(cartDetail.getQuantity() > 1){
                cartDetail.setQuantity(cartDetail.getQuantity() - 1);
                this.cartDetailRepository.save(cartDetail);
            }
            
        }
       
    }
}
