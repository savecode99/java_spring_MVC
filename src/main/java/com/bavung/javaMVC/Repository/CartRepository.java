package com.bavung.javaMVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.User;
import java.util.List;


@Repository

public interface CartRepository extends JpaRepository<Cart, Long>{
    Cart findByUser(User user);
    Cart save(Cart cart);
    Cart findById(long id);
}
