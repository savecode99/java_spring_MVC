package com.bavung.javaMVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bavung.javaMVC.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
