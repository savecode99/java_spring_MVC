package com.bavung.javaMVC.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.product;
@Repository
public interface ProductRepo extends JpaRepository<product, Long>{
    List<product> findAll();

    Optional<product> findById(Long id);

    product save(product product);

    void delete(product product);

    @Query("SELECT DISTINCT p.factory FROM product p")
    List<String> findAllDistinctFactory();

    List<product> findByFactory(String factory);
}
