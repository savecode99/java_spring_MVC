package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.product;
import com.bavung.javaMVC.Repository.ProductRepo;

@Service
public class ProductService {
    
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<product> getAllProduct()
    {
        return this.productRepo.findAll();
    }

    public Optional<product> getProductById(Long id)
    {
        return this.productRepo.findById(id);
    }

    public product save(product product)
    {
        return this.productRepo.save(product);
    }

    public void deleteProduct(product product)
    {
        this.productRepo.delete(product);
    }
}
