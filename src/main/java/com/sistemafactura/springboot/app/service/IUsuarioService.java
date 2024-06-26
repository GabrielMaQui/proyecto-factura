package com.sistemafactura.springboot.app.service;

import com.sistemafactura.springboot.app.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario findByUsername(String username);

    public Usuario guardarUsuario(Usuario usuario);

    List<Usuario> listarUsuario();

    Usuario obtenerUsuarioxId(long id);

    void actualizarUsuario(Usuario usuario);
}
