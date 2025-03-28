package com.bavung.javaMVC.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.Orders;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Repository.CartDetailRepository;
import com.bavung.javaMVC.Repository.CartRepository;
import com.bavung.javaMVC.Repository.OrderRepository;
import com.bavung.javaMVC.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private CartDetailRepository cartDetailRepository;
    public OrderService(OrderRepository orderRepository , UserRepository userRepository,
    CartRepository cartRepository, CartDetailRepository cartDetailRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartRepository =cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }
    public void handlePlaceOrder(String receiverName , String phoneNumber,String deliveryAddress , HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = this.userRepository.findByEmail((String)session.getAttribute("email"));
        Cart cart = this.cartRepository.findByUser(user);
        List<CartDetail> cartDetails= this.cartDetailRepository.findByCart(cart);
        long totalPrice = 0;
        for(CartDetail cartDetail: cartDetails){
            totalPrice += (long)cartDetail.getQuantity() * cartDetail.getPrice();
        }
        Orders order = new Orders();
        order.setNameReceiver(receiverName);
        order.setAddress(deliveryAddress);
        order.setPhoneNumber(phoneNumber);
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        this.orderRepository.save(order);
    }
}
