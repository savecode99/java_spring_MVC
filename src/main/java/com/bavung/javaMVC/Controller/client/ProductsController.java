package com.bavung.javaMVC.Controller.client;

import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {
    private ProductService productService;

    public ProductsController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProductList(Model model)
    {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "client/product/products";
    }
}
