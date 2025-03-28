package com.bavung.javaMVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Orders;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    
}
