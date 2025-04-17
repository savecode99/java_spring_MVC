package com.bavung.javaMVC.Controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Service.UserService;
import com.bavung.javaMVC.model.PasswordDTO;
import com.bavung.javaMVC.model.UserUpdateDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class ProfileController {
    private UserService userService;
    public ProfileController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/user/updateProfile/information")
    public String handleGetPageUpdateProfile(Model model , HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = this.userService.getUserByEmail(session.getAttribute("email").toString());
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();

        //userUpdateDTO.setId(user.getId());
        userUpdateDTO.setEmail(user.getEmail());
        userUpdateDTO.setFullName(user.getFullName());
        userUpdateDTO.setAddress(user.getAddress());
        userUpdateDTO.setPhoneNumber(user.getPhoneNumber());
        
        model.addAttribute("userUpdateDTO", userUpdateDTO);
      
        return "client/profile/UserUpdate";
    }
    @PostMapping("/user/updateProfile/information")
    public String handleUpdateUser(@ModelAttribute("userUpdateDTO") @Valid UserUpdateDTO userUpdateDTO , BindingResult userBindingResult , HttpServletRequest request ) {

        // List<FieldError> errors = userBindingResult.getFieldErrors();
        // for (FieldError error : errors ) {
        //     System.out.println (error.getField() + " - " + error.getDefaultMessage());
        // }

        if(userBindingResult.hasErrors())
        {
            return "client/profile/UserUpdate";
        }
        HttpSession session = request.getSession();
       // User currentUser = this.userService.findById(userUpdateDTO.getId()).get();
       User currentUser = this.userService.getUserByEmail(userUpdateDTO.getEmail());
        currentUser.setAddress(userUpdateDTO.getAddress());
        currentUser.setFullName(userUpdateDTO.getFullName());
        currentUser.setPhoneNumber(userUpdateDTO.getPhoneNumber());

        this.userService.handleSaveUser(currentUser);
        session.setAttribute("fullname", currentUser.getFullName());
        return "redirect:/";
    }
    @GetMapping("/user/updateProfile/change-password")
    public String handleGetPageChangePassword(Model model) {
        model.addAttribute("passwordDTO", new PasswordDTO());
        return "client/profile/change-password";
    }
    @PostMapping("/user/updateProfile/change-password")
    public String postMethodName(@ModelAttribute("passwordDTO") @Valid PasswordDTO passwordDTO , BindingResult passwordBindingResult , HttpServletRequest request , Model model) {
        //TODO: process POST request
        HttpSession session = request.getSession();
        User user = this.userService.getUserByEmail(session.getAttribute("email").toString());
        if(passwordBindingResult.hasErrors())
        {
            return "client/profile/change-password";
        }
        if(!this.userService.matchOldPassword(passwordDTO.getOldPassword(), user)){
            model.addAttribute("errorMessage", "Mật khẩu cũ không chính xác");
            return"client/profile/change-password";
        }
        if(!this.userService.matchNewPassword(passwordDTO.getNewPassword(), passwordDTO.getConfirmNewPassword())){
            model.addAttribute("errorMessage", "Mật khẩu mới không khớp");
            return"client/profile/change-password";
        }

        this.userService.updatePassword(user, passwordDTO.getConfirmNewPassword());
        model.addAttribute("successMessage", "Thay đổi mật khẩu thành công");
        return"client/profile/change-password";
        
    }
    
    
}
