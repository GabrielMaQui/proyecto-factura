package com.sistemafactura.springboot.app.repository;

import com.sistemafactura.springboot.app.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
}
