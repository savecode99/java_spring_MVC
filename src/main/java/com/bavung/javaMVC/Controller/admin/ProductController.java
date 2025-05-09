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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bavung.javaMVC.Entities.Category;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Service.CategoryService;
import com.bavung.javaMVC.Service.ProductService;
import com.bavung.javaMVC.Service.UpLoadFileService;

import jakarta.validation.Valid;




@Controller
public class ProductController {
   
    private ProductService productService;
    private UpLoadFileService upLoadFileService;
    private CategoryService categoryService;
    
    public ProductController( ProductService productService , UpLoadFileService upLoadFileService , CategoryService categoryService)
    {
        this.productService =  productService;
        this.upLoadFileService = upLoadFileService;
        this.categoryService = categoryService;
    }

    @GetMapping("admin/product")
    public String getProduct(Model model)
    {
        List<Product> items = this.productService.getAllProduct();
        model.addAttribute("listProduct", items);

        // for(product item : items)
        // {
        //     System.err.println(item.getPrice());
        // }
        return "admin/product/show";
    }
    @GetMapping("admin/product/create")
    public String getCreatProductPage(Model model) {
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        return "admin/product/create";
    }
    
    @PostMapping("admin/product/create")
    public String handleCreatProduct(@ModelAttribute("product") @Valid Product product  , 
                                    BindingResult bindingResultproduct,
                                    @RequestParam("file") MultipartFile file ) {
        String image = this.upLoadFileService.hanldeUpLoadFile(file, "product");
        if(bindingResultproduct.hasErrors())
        {
            return"admin/product/create";
        }
        //System.err.println(product.toString());
        product.setImage(image);
        this.productService.save(product);
        return "redirect:/admin/product";
    }
    
    @GetMapping("/admin/product/show/{id}")
    public String getDetailPage(@PathVariable Long id, Model model) {

        Optional<Product> result = this.productService.getProductById(id);
        
        model.addAttribute("id", id);
        if(result.isPresent())
        {
            model.addAttribute("product", result.get());
        }

        return "admin/product/ProductDetail";
    }
    
    @PostMapping("admin/product/delete/{id}")
    public String handleDelete(@PathVariable Long id ) {
        //TODO: process POST request       
        //System.err.println(id);
        Optional<Product> result = this.productService.getProductById(id);
        if(result.isPresent())
        {
            this.productService.deleteProduct(result.get());
        }
        return "redirect:/admin/product";
    }
    
    @GetMapping("admin/product/update/{id}")
    public String getMethodName(@PathVariable Long id , Model model) {
        List<Category> categories = this.categoryService.findAll();
        Optional<Product> result = this.productService.getProductById(id);
        model.addAttribute("product", result.get());
        model.addAttribute("categories", categories);
        return "/admin/product/ProductUpdate";
    }
    @PostMapping("admin/product/update")
    public String handleUpdateProduct(@ModelAttribute("product") @Valid Product pro ,
                                    BindingResult bindingResultproduct ,
                                    @RequestParam ("file") MultipartFile file  ) {
        Product CurrentProduct = this.productService.getProductById(pro.getId()).get();
        if(bindingResultproduct.hasErrors())
        {
            return "admin/product/ProductUpdate";
        }
        if(!file.isEmpty())
        {
            String image = this.upLoadFileService.hanldeUpLoadFile(file, "product");
            CurrentProduct.setImage(image);
        }
        CurrentProduct.setDetailDesc(pro.getDetailDesc());
        CurrentProduct.setCategory(pro.getCategory());
        CurrentProduct.setName(pro.getName());
        CurrentProduct.setPrice(pro.getPrice());
        CurrentProduct.setQuantity(pro.getQuantity());
        CurrentProduct.setShortDesc(pro.getShortDesc());

        this.productService.save(CurrentProduct);
        //TODO: process POST request
        
        return "redirect:/admin/product";
    }
    

}
