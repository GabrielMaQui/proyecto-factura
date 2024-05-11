package com.sistemafactura.springboot.app.service;

import com.sistemafactura.springboot.app.models.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listProductos();

    void registerProductos(Producto producto);

    void eliminarProducto(Long idproducto);

    public void disminuirStock(Long id, Integer cantidad);

}
