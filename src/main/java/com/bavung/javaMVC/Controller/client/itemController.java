package com.bavung.javaMVC.Controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Entities.product;
import com.bavung.javaMVC.Service.CartDetailService;
import com.bavung.javaMVC.Service.CartService;
import com.bavung.javaMVC.Service.ProductService;
import com.bavung.javaMVC.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;





@Controller
public class itemController {
    private ProductService productService;
    private UserService userService;
    private  CartService cartService;
    private CartDetailService cartDetailService;

    public itemController(ProductService productService , UserService userService , CartService cartService , CartDetailService cartDetailService){
        this.productService = productService;
        this.userService = userService;
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
    }
    @GetMapping("/product/{id}")
    public String DetailPage(@PathVariable Long id , Model model) {
        product product = this.productService.getProductById(id).get();
        model.addAttribute("product", product);
        return "/client/product/detail";
    }
    
    @PostMapping("/add-product/{productId}")
    public String postMethodName(@PathVariable long  productId , HttpServletRequest request) {
        //TODO: process POST request
        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");
        this.productService.handleAddProductToCart(email, productId , request);
        return "redirect:/";
    }
    
    @GetMapping("/cart-detail")
    public String getMethodName(Model model  , HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");
        User user = this.userService.getUserByEmail(email);
        Cart cart = this.cartService.findByUser(user);
        List<CartDetail> cartDetails= this.cartDetailService.findByCart(cart);
        long totalPrice = 0;
        for(CartDetail cartDetail: cartDetails){
            totalPrice += (long)cartDetail.getQuantity() * cartDetail.getPrice();
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("ListDetails", cartDetails);
        System.err.println(cartDetails.size());
        return "/client/cart/cart-detail";

    }

    @PostMapping("/delete-detail/{id}")
    public String postMethodName(@PathVariable long id) {
        //TODO: process POST request
        System.out.println(id);
        return "redirect:/cart-detail";
    }
    
    
}
