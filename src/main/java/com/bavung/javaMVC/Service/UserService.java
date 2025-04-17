package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.Role;
import com.bavung.javaMVC.Entities.User;
import com.bavung.javaMVC.Repository.RoleRepository;
import com.bavung.javaMVC.Repository.UserRepository;
import com.bavung.javaMVC.model.RegisterDTO;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    public UserService (UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
    {
         this.userRepository = userRepository;
         this.roleRepository = roleRepository;
         this.passwordEncoder = passwordEncoder;
    }

    public String sayhello()
    {
        return "hello from service";
    }  
    public void handleSaveUser(User userEntity)
    {
        this.userRepository.save(userEntity);
    }
    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(Long id)
    {
        return this.userRepository.findById(id);
    }
    public void deleteUById(long id)
    {
        this.userRepository.deleteById(id);
    }

    public Role findRoleByName(String name)
    {
        return this.roleRepository.findByName(name);
    }

    public boolean checkExistEmail(String email)
    {
        return this.userRepository.existsByEmail(email);
    }

    public User RegisterDTOtoUser(RegisterDTO registerDTO)
    {
        User user = new User();
        user.setFullName(registerDTO.getFirstName()+" "+registerDTO.getLastName());
        //user.setAddress(registerDTO.get);
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassWord());
        return user;

    }

    public User getUserByEmail(String email)
    {
        return this.userRepository.findByEmail(email);
    }

    public boolean matchOldPassword(String oldPassword , User user){
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }
    public boolean matchNewPassword(String newPassword , String comfirmNewPassword){
        return newPassword.equals(comfirmNewPassword);
    }

    public void updatePassword(User user , String newPassword){
        user.setPassword(passwordEncoder.encode(newPassword));
        this.userRepository.save(user);
    }
}
