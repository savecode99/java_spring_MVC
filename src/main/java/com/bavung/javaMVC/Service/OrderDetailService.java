package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Order_detail;
import com.bavung.javaMVC.Entities.Orders;
import com.bavung.javaMVC.Repository.OrderDetailRepository;

@Service
public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    public OrderDetailService(OrderDetailRepository orderDetailRepository){
        this.orderDetailRepository = orderDetailRepository;
    }
    public Optional<Order_detail> getOrders_detailById(long id){
        return this.orderDetailRepository.findById(id);
    }
    public List<Order_detail> getOrdersdetailByOrder(Orders order){
        return this.orderDetailRepository.findByOrder(order);
    }
}
