package com.bavung.javaMVC.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bavung.javaMVC.Entities.UserEntity;
import com.bavung.javaMVC.Service.UserService;









@Controller
public class buildAPI {
   
    private UserService userService;

    public buildAPI(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        String test = this.userService.sayhello();
        model.addAttribute("test", test);
        return "hello";
    }

    @RequestMapping("/admin/user/create")
    public String GetCreateUserPage (Model  model) {
        model.addAttribute("user", new UserEntity());
        return "admin/user/create";
    }
    
    @RequestMapping(value = "/admin/user/create", method= RequestMethod.POST)
    public String HandleCreateNewUser( @ModelAttribute("user") UserEntity user , BindingResult result) {
        if(result.hasErrors()){
            return "admin/user/create";
        }
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String ShowUserTable(Model  model)
    {
        List<UserEntity> userList = new ArrayList<>();
        userList = this.userService.findAll(); 
        System.err.println(userList);
        model.addAttribute("listUser", userList );
        return "admin/user/tableUser";
    }

    @RequestMapping("admin/user/show/{id}")
    public String handleShowUserDetail(Model model,@PathVariable Long id ) {
        Optional<UserEntity> result = this.userService.findById(id);
        System.err.println(result);
        if(result.isPresent())
        {
            model.addAttribute("userDetail", result.get());
        }
        else
        {
            model.addAttribute("userDetail", null);
        }
        model.addAttribute("id", id);
        return "admin/user/UserDetail";
    }

    @GetMapping("admin/user/update/{id}")
    public String UpdateUser(Model model, @PathVariable Long id)
    {
        Optional<UserEntity> result = this.userService.findById(id);
       // System.err.println(result.get());
        model.addAttribute("user", result.get());
        return "admin/user/UserUpdate";
    }
    
    @PostMapping("admin/user/update")
    public String handleUpdateUser(@ModelAttribute("user") UserEntity user  ) {
        UserEntity currentUser = this.userService.findById(user.getId()).get();

        currentUser.setAddress(user.getAddress());
        currentUser.setFullName(user.getFullName());
        currentUser.setPhoneNumber(user.getPhoneNumber());
        this.userService.handleSaveUser(currentUser);
        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/delete/{id}")
    public String DeleteUser(Model model, @PathVariable Long id) {
        
        model.addAttribute("id", id);
        UserEntity User = new UserEntity();
        User.setId(id);
        model.addAttribute("user", User);
        return  "admin/user/UserDelete";
    }
    
    @PostMapping("admin/user/delete")
    public String handleDeleteUser(Model model , @ModelAttribute("user") UserEntity User) {
        
        this.userService.deleteUById(User.getId());
        return "redirect:/admin/user";
    }
    
    

}
