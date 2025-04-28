package com.bavung.javaMVC.Controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bavung.javaMVC.Entities.Orders;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Service.OrderService;
import com.bavung.javaMVC.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class UserOrderController {
    private OrderService orderService;
    private UserService userService;
    public UserOrderController(OrderService orderService ,UserService userService){
        this.orderService = orderService;
        this.userService = userService;
    }
    @PostMapping("/place-order")
    public String placeOrder(@RequestParam String receiverName ,@RequestParam String phoneNumber,
        @RequestParam String deliveryAddress , HttpServletRequest request) {
            this.orderService.handlePlaceOrder(receiverName, phoneNumber, deliveryAddress, request);
            // System.out.println(receiverName);
            // System.out.println(phoneNumber);
            // System.out.println(deliveryAddress);
            
        return "redirect:/";
    }
    @GetMapping("/user/orders")
    public String handleShowOrders(HttpServletRequest request , Model model) {
        HttpSession session = request.getSession();
        User user = this.userService.getUserByEmail(session.getAttribute("email").toString());
        List<Orders> orders = this.orderService.getOrdersByUser(user);
        model.addAttribute("orders", orders);
        return "client/order/show";
    }
    @PostMapping("/user/cancel/order/{orderId}")
    public String handleCancelOrders(@PathVariable long orderId) {
        //TODO: process POST request
        Optional<Orders> res = this.orderService.getOrderById(orderId);
        if(!res.isEmpty()){
            Orders order = res.get();
            this.orderService.handleCancelOrder(order);
        }
        
        return "redirect:/user/orders";
    }
    
}
