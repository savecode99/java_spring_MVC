package com.bavung.javaMVC.Controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.Order_detail;
import com.bavung.javaMVC.Entities.Orders;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Service.OrderDetailService;
import com.bavung.javaMVC.Service.OrderService;
import com.bavung.javaMVC.Service.ProductService;



@Controller
public class AdminOrderController {
    private OrderService orderService;
    private OrderDetailService orderDetailService;
    private ProductService productService;
    public AdminOrderController(OrderService orderService , OrderDetailService orderDetailService , ProductService productService){
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.productService = productService;
    }
    @GetMapping("/admin/order")
    public String handleShowAllOrder(Model model)
    {
        List<Orders> ListOrder = this.orderService.getAllOrders();
        model.addAttribute("ListOrder", ListOrder);
        return "admin/order/show";
    }

    @GetMapping("/admin/order/show/{orderId}")
    public String handleShowOrderDetail(@PathVariable long orderId , Model model) {
        Optional<Orders> res = this.orderService.getOrderById(orderId);
        if(!res.isEmpty()){
            List<Order_detail> listOrder_details = this.orderDetailService.getOrdersdetailByOrder(res.get());
            model.addAttribute("listOrder_details", listOrder_details);
        }
        
        return "admin/order/OrderDetail";
    }
    @GetMapping("/admin/order/cancel/{orderId}")
    public String handleCancelOrder(@PathVariable long orderId) {
        Optional<Orders> res = this.orderService.getOrderById(orderId);
        if(!res.isEmpty()){
            Orders order = res.get();
            this.orderService.handleCancelOrder(order);
        }
        
        return "redirect:/admin/order";
    }
    @PostMapping("/admin/order/confirm/{orderId}")
    public String handleConfirmOrder(@PathVariable long orderId) {
        //TODO: process POST request
        Optional<Orders> res = this.orderService.getOrderById(orderId);
        if(!res.isEmpty()){
            Orders order = res.get();
            this.orderService.handleConfirmOrder(order);
        }
        return "redirect:/admin/order";
    }
    @PostMapping("/admin/order/shipping/{orderId}")
    public String handleShipOrder(@PathVariable long orderId) {
        //TODO: process POST request
        Optional<Orders> res = this.orderService.getOrderById(orderId);
        if(!res.isEmpty()){
            Orders order = res.get();
            this.orderService.handleShippingOrder(order);
        }
        return "redirect:/admin/order";
    }
    @PostMapping("/admin/order/delivered/{orderId}")
    public String handleDeliveredOrder(@PathVariable long orderId) {
        //TODO: process POST request
        Optional<Orders> res = this.orderService.getOrderById(orderId);
        if(!res.isEmpty()){
            Orders order = res.get();
            this.orderService.handleDeliveredOrder(order);
            List<Order_detail> listOrder_details = this.orderDetailService.getOrdersdetailByOrder(order);
            for(Order_detail x : listOrder_details){
                Product p = x.getProduct();
                long currentQuantity = p.getQuantity();
                p.setQuantity( currentQuantity - x.getQuantity());
                this.productService.save(p);
            }
        }
        return "redirect:/admin/order";
      
    }
    
    
}
