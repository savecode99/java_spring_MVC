package com.bavung.javaMVC.Controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Service.CategoryService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;





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
    
    @PostMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        this.categoryService.handleDeleteCategory(id);
        // System.out.println(id);
        return "redirect:/admin/category";
    }
    @GetMapping("admin/category/update/{id}")
    public String getUpdateCategoryPage(@PathVariable Long id , Model model) {
        Optional<Category> res = this.categoryService.findById(id);

        model.addAttribute("category", res.get());
        return "/admin/category/categoryUpdate";
    }
    @PostMapping("/admin/category/update")
    public String handleUpdate(@ModelAttribute("category") @Valid Category category ,
    BindingResult bindingResultproduct ) {
        //TODO: process POST request
        if(bindingResultproduct.hasErrors())
        {
            return "admin/category/categoryUpdate";
        }
        long id = category.getId();
        Optional<Category> res = this.categoryService.findById(id);
        if(!res.isEmpty()){
            Category curentCategory = res.get();
            curentCategory.setName(category.getName());
            curentCategory.setDescription(category.getDescription());
        }
        return "redirect:/admin/category";
    }
    

}
