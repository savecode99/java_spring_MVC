package com.bavung.javaMVC.Controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Service.CategoryService;
import com.bavung.javaMVC.Service.ProductService;


@Controller
public class HomePageController {
    private  ProductService productService;
    private  CategoryService categoryService;
    public HomePageController(ProductService productService , CategoryService categoryService)
    {
        this.productService = productService;
        this.categoryService =categoryService;
    }
    @GetMapping("/") 
    public String getHomePage(Model model){
        List<Product> items = this.productService.getAllProduct();
        List<Category> categories = this.categoryService.getAllCategory();
        model.addAttribute("listPro", items);
        model.addAttribute("categories", categories);
        return "client/homePage/show";
    }
    @GetMapping("/filterByCategory")
    public String filterByFactory(@RequestParam("category") String categoryName, Model model) {
        Category category = this.categoryService.findByName(categoryName);
        List<Product> items = this.productService.getProductByCateGory(category); 
        List<Category> categories = this.categoryService.getAllCategory();
        model.addAttribute("listPro", items);
        model.addAttribute("categories", categories);
        return "client/homePage/show";
    }
    @GetMapping("/client/chat")
    public String getChatPage() {
        return "client/chat/chat_client";
    }
    

}
