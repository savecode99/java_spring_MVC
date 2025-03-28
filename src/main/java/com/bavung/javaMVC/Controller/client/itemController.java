package com.bavung.javaMVC.Controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Service.CartDetailService;
import com.bavung.javaMVC.Service.CartService;
import com.bavung.javaMVC.Service.ProductService;
import com.bavung.javaMVC.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;






@Controller
public class ItemController {
    private ProductService productService;
    private UserService userService;
    private  CartService cartService;
    private CartDetailService cartDetailService;

    public ItemController(ProductService productService , UserService userService , CartService cartService , CartDetailService cartDetailService){
        this.productService = productService;
        this.userService = userService;
        this.cartService = cartService;
        this.cartDetailService = cartDetailService;
    }
    @GetMapping("/product/{id}")
    public String DetailPage(@PathVariable Long id , Model model) {
        Product product = this.productService.getProductById(id).get();
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
    public String showCartDetail(Model model  , HttpServletRequest request) {
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
        //System.out.println(cartDetails.size());
        return "/client/cart/cart-detail";

    }

    @PostMapping("/delete-detail/{productId}")
    public String handleDeleteProduct( @PathVariable long productId , HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");
        User user = this.userService.getUserByEmail(email);
        Cart cart = this.cartService.findByUser(user);
        
        Optional<Product> res = this.productService.getProductById(productId);
        if(!res.isEmpty()){
            Product product = res.get();
            this.cartDetailService.deleteByProductAndCart(product ,cart);
            cart.setSum(cart.getSum()-1);
            cart = this.cartService.SaveCart(cart);
            session.setAttribute("sum",cart.getSum() );
        }
        //TODO: process POST request
        // System.out.println( "id p" + productId);
        // System.out.println( session.getAttribute("sum"));

        return "redirect:/cart-detail";
    }
    
    @PostMapping("/increase-quantity-detail/{productId}/{cartId}")
    public String handldeIncreaseQuantity(@PathVariable("productId") long productId , @PathVariable("cartId") long cartId ) {
        //TODO: process POST request
        System.out.println(productId + " " + cartId);
        this.cartDetailService.IncreaseQuantity(productId, cartId);
        return  "redirect:/cart-detail";
    } 
    
    @PostMapping("/decrease-quantity-detail/{productId}/{cartId}")
    public String handldeDecreaseQuantity(@PathVariable("productId") long productId , @PathVariable("cartId") long cartId ) {
        //TODO: process POST request
        this.cartDetailService.DecreaseQuantity(productId, cartId);
        return  "redirect:/cart-detail";
    } 
    
}
