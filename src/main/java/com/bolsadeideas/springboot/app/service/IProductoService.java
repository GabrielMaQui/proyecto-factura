package com.bolsadeideas.springboot.app.service;

import com.bolsadeideas.springboot.app.models.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listProductos();
    void registerProductos(Producto producto);
    void eliminarProducto(Long idproducto);
    public void disminuirStock(Long id, Integer cantidad);

}
