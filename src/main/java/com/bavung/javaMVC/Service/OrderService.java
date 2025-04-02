package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.Order_detail;
import com.bavung.javaMVC.Entities.Orders;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Enum.StatusEnum;
import com.bavung.javaMVC.Repository.CartDetailRepository;
import com.bavung.javaMVC.Repository.CartRepository;
import com.bavung.javaMVC.Repository.OrderDetailRepository;
import com.bavung.javaMVC.Repository.OrderRepository;
import com.bavung.javaMVC.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private CartDetailRepository cartDetailRepository;
    public OrderService(OrderRepository orderRepository , UserRepository userRepository,
    CartRepository cartRepository, CartDetailRepository cartDetailRepository,
    OrderDetailRepository orderDetailRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartRepository =cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.orderDetailRepository = orderDetailRepository;
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
        order.setStatusEnum(StatusEnum.PENDING);
        order.setTotalPrice(totalPrice);
        this.orderRepository.save(order);

        
        for(CartDetail x : cartDetails){
            Order_detail order_detail = new Order_detail();
            order_detail.setOrder(order);
            order_detail.setProduct(x.getProduct());
            order_detail.setQuantity(x.getQuantity());
            order_detail.setPrice(x.getPrice());
            this.orderDetailRepository.save(order_detail);
        }
        for(CartDetail x : cartDetails){
            this.cartDetailRepository.delete(x);
        }
        this.cartRepository.delete(cart);
        session.setAttribute("sum", 0);

    }

    public List<Orders> getAllOrders(){
       return this.orderRepository.findAll();
    }
    public Optional<Orders> getOrderById(long id){
        return this.orderRepository.findById(id);
    }
}