package com.bavung.javaMVC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.Product;

import jakarta.transaction.Transactional;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
    CartDetail findByCartAndProduct(Cart cart , Product product);
    List<CartDetail> findByCart(Cart cart);
   @Transactional
    void deleteByProductAndCart(Product product ,Cart cart);
    
}
