package com.sistemafactura.springboot.app.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Data
@Entity
@Table(name = "authorities", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})})
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
    private Long user_id;
}
