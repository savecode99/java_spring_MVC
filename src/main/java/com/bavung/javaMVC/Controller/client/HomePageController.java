package com.bavung.javaMVC.Controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<String> factory = this.productService.getALLFactory();
        model.addAttribute("listPro", items);
        model.addAttribute("listFac", factory);
        return "client/homePage/show";
    }
    @GetMapping("/filterByFactory")
    public String filterByFactory(@RequestParam("factory") String factory, Model model) {
        List<product> items = this.productService.getProductsByFactory(factory); // Thêm phương thức này trong ProductService
        List<String> factoryList = this.productService.getALLFactory();
        model.addAttribute("listPro", items);
        model.addAttribute("listFac", factoryList);
        return "client/homePage/show";
}

}
