package com.bavung.javaMVC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
    CartDetail findByCartAndProduct(Cart cart , product product);
    List<CartDetail> findByCart(Cart cart);
}
