package com.bolsadeideas.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c left join fetch c.facturas f where c.id=:id")
    public Cliente fetchByIdWithFacturas(@Param("id") Long id);

}
