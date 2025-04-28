package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Repository.CategoryRepository;
import com.bavung.javaMVC.Repository.ProductRepo;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepo productRepo;
    public CategoryService(CategoryRepository categoryRepository , ProductRepo productRepo){
        this.categoryRepository = categoryRepository;
        this.productRepo = productRepo;
    }
    public List<Category> getAllCategory(){
        return this.categoryRepository.findAll();
    }
    public Category saveCategory(Category category){
        return this.categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }
    public Category findByName(String name){
        return this.categoryRepository.findByName(name);
    }
    public void handleDeleteCategory(long id){
        Optional<Category> res = this.categoryRepository.findById(id);
        if(!res.isEmpty()){
            Category category = res.get();
            List<Product> ls = this.productRepo.findByCategory(category);
            if(ls.isEmpty()){
                this.categoryRepository.delete(category);
            }else{
                System.out.println("Con san pham lien quan");
            }
        }
    }
    public Optional<Category> findById(long id){
        return this.categoryRepository.findById(id);
    }
}
