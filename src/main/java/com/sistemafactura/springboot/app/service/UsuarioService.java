package com.sistemafactura.springboot.app.service;

import com.sistemafactura.springboot.app.models.entity.Role;
import com.sistemafactura.springboot.app.models.entity.Usuario;
import com.sistemafactura.springboot.app.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(
                usuario.getPassword()));
        usuario.setEnabled(true);
        Role userRole = new Role();
        userRole.setAuthority("ROLE_USER");

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioxId(long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(
                usuario.getNombre(), usuario.getApellido(),
                usuario.getEnabled(), bCryptPasswordEncoder.encode(usuario.getPassword()), usuario.getId()
        );
    }
}
