package com.bavung.javaMVC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bavung.javaMVC.Entities.UserEntity;
import com.bavung.javaMVC.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String sayhello()
    {
        return "hello from service";
    }  
    public void handleSaveUser(UserEntity userEntity)
    {
        userRepository.save(userEntity);
    }
    public List<UserEntity> findAll()
    {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id)
    {
        return userRepository.findById(id);
    }
    public void deleteUById(long id)
    {
        userRepository.deleteById(id);
    }

}
