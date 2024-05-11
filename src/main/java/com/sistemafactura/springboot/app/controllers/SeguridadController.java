package com.sistemafactura.springboot.app.controllers;


import com.sistemafactura.springboot.app.models.dto.request.UsuarioRequest;
import com.sistemafactura.springboot.app.models.dto.response.ResultadoResponse;
import com.sistemafactura.springboot.app.models.entity.Role;
import com.sistemafactura.springboot.app.models.entity.Usuario;
import com.sistemafactura.springboot.app.service.IRoleService;
import com.sistemafactura.springboot.app.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
    private IUsuarioService iUsuarioService;
    private IRoleService iRoleService;


    @GetMapping("/usuario")
    public String frmUsuario(Model model) {
        model.addAttribute("listaUsuario", iUsuarioService.listarUsuario());
        return "seguridad/formusuario";
    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(@PathVariable("id") int id) {
        return iUsuarioService.obtenerUsuarioxId(id);
    }

    @PostMapping("/usuario/registrar")
    @ResponseBody
    public ResultadoResponse registrarUsuario(@RequestBody
                                              UsuarioRequest usuarioRequest) {
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try {
            Usuario usuario = new Usuario();
            usuario.setNombre(usuarioRequest.getNombres());
            usuario.setApellido(usuarioRequest.getApellidos());

            if (usuarioRequest.getId() > 0) {
                usuario.setId(usuarioRequest.getId());
                usuario.setEnabled(usuarioRequest.getEnabled());
                iUsuarioService.actualizarUsuario(usuario);
            } else {
                usuario.setUsername(usuarioRequest.getUsername());
                usuario.setPassword(usuarioRequest.getPassword());
                iUsuarioService.guardarUsuario(usuario);
                Role role = new Role();
                role.setUser_id(usuario.getId());
                role.setAuthority("ROLE_USER");
                iRoleService.guardarRol(role);
            }

        } catch (Exception ex) {
            mensaje = "Usuario no registrado, error en la BD";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje)
                .respuesta(respuesta).build();
    }


    @GetMapping("/usuario/lista")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        return iUsuarioService.listarUsuario();
    }


}
