package com.bavung.javaMVC.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void delete(Product product);

    // @Query("SELECT DISTINCT p.factory FROM Product p")
    // List<String> findAllDistinctFactory();

    List<Product> findByCategory(Category category);
}
