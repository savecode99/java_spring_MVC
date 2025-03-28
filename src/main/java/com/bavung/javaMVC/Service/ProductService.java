package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Cart;
import com.bavung.javaMVC.Entities.CartDetail;
import com.bavung.javaMVC.Entities.Product;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Repository.CartDetailRepository;
import com.bavung.javaMVC.Repository.CartRepository;
import com.bavung.javaMVC.Repository.ProductRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {
    private UserService userService;
    private ProductRepo productRepo;
    private CartRepository cartRepository;
    private CartDetailRepository cartDetailRepository;

    public ProductService(ProductRepo productRepo, UserService userService,CartRepository cartRepository,   CartDetailRepository cartDetailRepository){
        this.productRepo = productRepo;
        this.userService = userService;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public List<Product> getAllProduct()
    {
        return this.productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id)
    {
        return this.productRepo.findById(id);
    }

    public Product save(Product product)
    {
        return this.productRepo.save(product);
    }

    public void deleteProduct(Product product)
    {
        this.productRepo.delete(product);
    }

    public List<String> getALLFactory()
    {
        return this.productRepo.findAllDistinctFactory();
    }
    public List<Product> getProductsByFactory(String factory)
    {
        return this.productRepo.findByFactory(factory);
    }

    public void handleAddProductToCart(String email , Long productId , HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        User user = this.userService.getUserByEmail(email);
        if(user != null)
        {
            Cart cart = this.cartRepository.findByUser(user);
            if(cart == null)
            {
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(0);
                cart = this.cartRepository.save(otherCart);
            }

            Optional<Product> result = this.productRepo.findById(productId);
            if(result.isPresent())
            {
                Product product = result.get();
                CartDetail oldCartDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);
                if(oldCartDetail != null){
                    oldCartDetail.setQuantity(oldCartDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldCartDetail);
                }else{
                    CartDetail cartDetail = new CartDetail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(product);
                    cartDetail.setPrice(product.getPrice());

                    cartDetail.setQuantity(1);
                    this.cartDetailRepository.save(cartDetail);

                    cart.setSum(cart.getSum()+1);
                    this.cartRepository.save(cart);
                    
                    session.setAttribute("sum", cart.getSum());
                        
                }
                
            }

        }
    }

}
