package com.bavung.javaMVC.Controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Service.UpLoadFileService;
import com.bavung.javaMVC.Service.UserService;

import jakarta.validation.Valid;
@Controller

public class UserController {

    private UserService userService;
    private UpLoadFileService upLoadFileService;
    private PasswordEncoder passwordEncoder;


    public UserController(UserService userService , UpLoadFileService upLoadFileService , PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.upLoadFileService = upLoadFileService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        String test = this.userService.sayhello();
        model.addAttribute("test", test);
        return "hello";
    }

    @RequestMapping("/admin/user/create")
    public String GetCreateUserPage (Model  model) {
        model.addAttribute("user", new User());
        return "admin/user/create";
    }
    
    @RequestMapping(value = "/admin/user/create", method= RequestMethod.POST)
    public String HandleCreateNewUser(  @ModelAttribute("user") @Valid User user ,
                                        BindingResult userbindingResult,
                                        @RequestParam("file") MultipartFile file) {

        List<FieldError> errors = userbindingResult.getFieldErrors();
        for (FieldError error : errors ) {
            System.out.println (error.getField() + " - " + error.getDefaultMessage());
        }

        if(userbindingResult.hasErrors())
        {
            return "admin/user/create";
        }
        String avatar = this.upLoadFileService.hanldeUpLoadFile(file, "avatar");
        user.setRole(this.userService.findRoleByName(user.getRole().getName()));
        user.setAvatar(avatar);
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);

        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String ShowUserTable(Model  model)
    {
        List<User> userList = new ArrayList<>();
        userList = this.userService.findAll(); 
        System.err.println(userList);
        model.addAttribute("listUser", userList );
        return "admin/user/ShowTableUser";
    }

    @RequestMapping("admin/user/show/{id}")
    public String handleShowUserDetail(Model model,@PathVariable Long id ) {
        Optional<User> result = this.userService.findById(id);
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

    // @GetMapping("admin/user/update/{id}")
    // public String UpdateUser(Model model, @PathVariable Long id)
    // {
    //     Optional<User> result = this.userService.findById(id);
    //    // System.err.println(result.get());
    //     model.addAttribute("user", result.get());
    //     return "admin/user/UserUpdate";
    // }
    
    // @PostMapping("admin/user/update")
    // public String handleUpdateUser(@ModelAttribute("user") User user  ) {
    //     User currentUser = this.userService.findById(user.getId()).get();

    //     currentUser.setAddress(user.getAddress());
    //     currentUser.setFullName(user.getFullName());
    //     currentUser.setPhoneNumber(user.getPhoneNumber());
    //     this.userService.handleSaveUser(currentUser);
    //     return "redirect:/admin/user";
    // }

    @GetMapping("admin/user/delete/{id}")
    public String DeleteUser(Model model, @PathVariable Long id) {
        
        model.addAttribute("id", id);
        User User = new User();
        User.setId(id);
        model.addAttribute("user", User);
        return  "admin/user/UserDelete";
    }
    
    @PostMapping("admin/user/delete")
    public String handleDeleteUser(Model model , @ModelAttribute("user") User User) {
        
        this.userService.deleteUById(User.getId());
        return "redirect:/admin/user";
    }
    
}
