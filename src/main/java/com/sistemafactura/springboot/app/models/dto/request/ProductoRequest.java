package com.sistemafactura.springboot.app.models.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ProductoRequest {
    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;
    private Boolean activo;
    private Integer stock;
}
