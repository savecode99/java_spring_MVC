package com.bavung.javaMVC.Controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Service.CategoryService;

import jakarta.validation.Valid;




@Controller
public class CategoryController {
    private CategoryService categoryService;
     public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/admin/category")
    public String handleShowCategories(Model model) {
        List<Category> categories  = this.categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "admin/category/show";
    }

    @GetMapping("/admin/category/create")
    public String handleGetCreatePageCategory(Model model) {
        model.addAttribute("category", new Category());
        return "admin/category/create";
    }
    
    @PostMapping("/admin/category/create")
    public String handleCreateCategory(@ModelAttribute("category") @Valid Category category ,
                                    BindingResult CategoryBindingResult ) {
        //TODO: process POST request
        if(CategoryBindingResult.hasErrors()){
            return "admin/category/create";
        }
        this.categoryService.saveCategory(category);
        return "redirect:/admin/category";
    }
    
    

}
