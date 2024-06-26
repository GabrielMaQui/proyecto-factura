package com.sistemafactura.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistemafactura.springboot.app.models.entity.Cliente;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c left join fetch c.facturas f where c.id=:id")
    public Cliente fetchByIdWithFacturas(@Param("id") Long id);

}
