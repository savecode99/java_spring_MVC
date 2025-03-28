package com.bavung.javaMVC.Controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bavung.javaMVC.Service.OrderService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserOrderController {
    private OrderService orderService;
    public UserOrderController(OrderService orderService){
        this.orderService = orderService;
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
}
