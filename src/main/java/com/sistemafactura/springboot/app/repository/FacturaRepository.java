package com.sistemafactura.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sistemafactura.springboot.app.models.entity.Factura;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id =:id")
    public Factura fetchByIdWithClienteWithItemFacturaWithProducto(@Param("id") Long id);

}