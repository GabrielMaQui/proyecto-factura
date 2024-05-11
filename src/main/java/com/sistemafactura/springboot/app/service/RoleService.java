package com.sistemafactura.springboot.app.service;

import com.sistemafactura.springboot.app.models.entity.Role;
import com.sistemafactura.springboot.app.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService implements IRoleService {
    private RolRepository rolRepository;

    @Override
    public Role guardarRol(Role role) {
        return rolRepository.save(role);
    }
}
