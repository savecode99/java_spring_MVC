package com.bavung.javaMVC.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.bavung.javaMVC.Service.CustomUserDetailsService;
import com.bavung.javaMVC.Service.UserService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    
    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return new CustomUserDetailsService(userService);   
    }

    @Bean
    public AuthenticationSuccessHandler customAuthSussesHandler(UserService userService){
        return new CustomAuthSussesHandler(userService);
    }
    @Bean
    public DaoAuthenticationProvider authProvider(PasswordEncoder passwordEncoder,UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        authProvider.setHideUserNotFoundExceptions(false);
        return authProvider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationSuccessHandler customAuthSussesHandler) throws Exception {
        
        http
            .authorizeHttpRequests(authorize -> authorize
                .dispatcherTypeMatchers(DispatcherType.FORWARD,
                    DispatcherType.INCLUDE) 
                    // cho phép truy cập đến service ()
                .permitAll()
                // cho phép forward từ "/login" truy cập tới view

                .requestMatchers( "/client/**", "/css/**", "/js/**", "/images/**", "/product/**","/register","/","/login", "/filterByFactory")
                .permitAll()

                .requestMatchers("/admin/**").hasRole("ADMIN")

                .anyRequest().authenticated())
                //.anyRequest().permitAll())
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .failureUrl("/login?error")
                .successHandler(customAuthSussesHandler)
                .permitAll())
            .sessionManagement((sessionManagement) -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .invalidSessionUrl("/logout?expired")
                .maximumSessions(1)
                .expiredUrl("/login?expired=true") // ve trang login neu bi dang nha
                .maxSessionsPreventsLogin(false))
                
                .logout(logout->logout.deleteCookies("JSESSIONID").invalidateHttpSession(true))
                

            .logout(logout -> logout
                .logoutUrl("/logout")           // URL xử lý logout
                .logoutSuccessUrl("/")          // Trang chủ sau khi logout
                .invalidateHttpSession(true)    // Hủy session
                .deleteCookies("JSESSIONID")    // Xóa cookie session
                .permitAll());
        return http.build();
    }

    @Bean
    public HttpFirewall allowUrlDoubleSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }
    
}
