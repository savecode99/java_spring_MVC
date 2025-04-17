package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Repository.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
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
}
