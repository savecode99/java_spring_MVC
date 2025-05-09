package com.bavung.javaMVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bavung.javaMVC.Entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
