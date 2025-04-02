package com.bavung.javaMVC.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Order_detail;
import com.bavung.javaMVC.Entities.Orders;



@Repository
public interface OrderDetailRepository extends JpaRepository<Order_detail, Long>{
    Optional<Order_detail> findById(Long id);
    List<Order_detail> findByOrder(Orders order);
}
