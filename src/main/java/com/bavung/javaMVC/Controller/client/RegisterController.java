package com.bavung.javaMVC.Controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Service.UpLoadFileService;
import com.bavung.javaMVC.Service.UserService;
import com.bavung.javaMVC.model.RegisterDTO;

import jakarta.validation.Valid;




@Controller
public class RegisterController {
    private PasswordEncoder passwordEncoder;
    private UserService userService;
    private UpLoadFileService upLoadFileService;
    public RegisterController(UserService userService , UpLoadFileService upLoadFileService , PasswordEncoder passwordEncoder)
    {
        this.userService = userService;
        this.upLoadFileService = upLoadFileService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("userRegister", new RegisterDTO() );
        return "client/auth/register";
    }
    
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("userRegister") @Valid RegisterDTO registerDTO ,
                                BindingResult bindingResult ) {

        
        if(bindingResult.hasErrors())
        {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getField() + " - " + error.getDefaultMessage());
            }
            return "client/auth/register";
        }
        
        //TODO: process POST request
        //System.err.println(registerDTO.getFirstName());
        User user = this.userService.RegisterDTOtoUser(registerDTO);
        user.setRole(this.userService.findRoleByName("USER"));
        String hashPassWord = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassWord);
        this.userService.handleSaveUser(user);
        return "/client/auth/login";
    }
    @GetMapping("/login")
    public String getLogin() {
       // model.addAttribute("userRegister", new RegisterDTO() );
        return "client/auth/login";
    }

    
    
    
}
