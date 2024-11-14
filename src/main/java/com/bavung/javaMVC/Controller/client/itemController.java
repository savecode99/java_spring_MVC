package com.bavung.javaMVC.Controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bavung.javaMVC.Entities.product;
import com.bavung.javaMVC.Service.ProductService;


@Controller
public class itemController {
    private ProductService productService;
    public itemController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product/{id}")
    public String DetailPage(@PathVariable Long id , Model model) {
        product product = this.productService.getProductById(id).get();
        model.addAttribute("product", product);
        return "/client/product/detail";
    }
    
}
