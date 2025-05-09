package com.bavung.javaMVC.Config;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Service.UserService;



@Service
public class CustomUserDetailsService implements UserDetailsService{

    private UserService userService;
    public  CustomUserDetailsService(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        com.bavung.javaMVC.Entities.User user = this.userService.getUserByEmail(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("Sai tên đăng nhập hoặc mật khẩu");
        }
       
       return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName())));
    }
    
}
