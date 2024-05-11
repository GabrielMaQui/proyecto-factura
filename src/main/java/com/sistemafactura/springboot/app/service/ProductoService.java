package com.sistemafactura.springboot.app.service;

import com.sistemafactura.springboot.app.models.entity.Producto;
import com.sistemafactura.springboot.app.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void registerProductos(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long idproducto) {
        productoRepository.deleteById(idproducto);
    }

    @Override
    public void disminuirStock(Long id, Integer cantidad) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            int stockActual = producto.getStock();
            int nuevoStock = stockActual - cantidad;
            if (nuevoStock >= 0) {
                producto.setStock(nuevoStock);
                productoRepository.save(producto);
            } else {
                throw new RuntimeException("No hay suficiente stock disponible para este producto.");
            }
        } else {
            throw new RuntimeException("Producto no encontrado.");
        }
    }
}
