package com.sistemafactura.springboot.app.models.dto.request;


import lombok.Data;

@Data
public class UsuarioRequest {

    private long id;
    private String username;
    private String password;
    private Boolean enabled;
    private String nombres;
    private String apellidos;
}
