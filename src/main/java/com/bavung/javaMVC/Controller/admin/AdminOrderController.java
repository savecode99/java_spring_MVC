package com.bavung.javaMVC.Controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bavung.javaMVC.Entities.Order_detail;
import com.bavung.javaMVC.Entities.Orders;
import com.bavung.javaMVC.Service.OrderDetailService;
import com.bavung.javaMVC.Service.OrderService;

@Controller
public class AdminOrderController {
    private OrderService orderService;
    private OrderDetailService orderDetailService;
    public AdminOrderController(OrderService orderService , OrderDetailService orderDetailService ){
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }
    @GetMapping("admin/order")
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
        
        return "showDetail";
    }
    
}
