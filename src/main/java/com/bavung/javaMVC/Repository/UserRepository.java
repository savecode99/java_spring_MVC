package com.bavung.javaMVC.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.User;
@Repository
public interface  UserRepository extends  JpaRepository<User, Long>{
    User save(User userEntity);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
