package com.bolsadeideas.springboot.app.service;

import com.bolsadeideas.springboot.app.models.entity.Role;
import com.bolsadeideas.springboot.app.repository.RolRepository;
import com.bolsadeideas.springboot.app.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService implements IRoleService{
    private RolRepository rolRepository;
    @Override
    public Role guardarRol(Role role) {
        return rolRepository.save(role);
    }
}
