package com.bolsadeideas.springboot.app.models.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
