package com.bavung.javaMVC.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.UserEntity;
@Repository
public interface  UserRepository extends  JpaRepository<UserEntity, Long>{
    UserEntity save(UserEntity userEntity);
     List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    void deleteById(Long id);
}
