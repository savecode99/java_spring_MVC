package com.bavung.javaMVC.Controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bavung.javaMVC.Entities.product;
import com.bavung.javaMVC.Service.ProductService;


@Controller
public class HomePageController {
    private  ProductService productService;

    public HomePageController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping("/") 
    public String getHomePage(Model model){
        List<product> items = this.productService.getAllProduct();
        model.addAttribute("listPro", items);
        return "client/homePage/show";
    }

}
