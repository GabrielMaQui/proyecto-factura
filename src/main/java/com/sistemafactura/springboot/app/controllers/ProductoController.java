package com.sistemafactura.springboot.app.controllers;


import com.sistemafactura.springboot.app.models.dto.request.ProductoRequest;
import com.sistemafactura.springboot.app.models.dto.response.ResultadoResponse;
import com.sistemafactura.springboot.app.models.entity.Producto;
import com.sistemafactura.springboot.app.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/producto")
public class ProductoController {
    private IProductoService iProductService;

    @GetMapping("")
    public String formProduct(Model model) {

        model.addAttribute("listproduct", iProductService.listProductos());
        model.addAttribute("titulo", "Lista de productos");
        return "product/formproduct";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Producto> listProducts() {
        return iProductService.listProductos();
    }


    @PostMapping("/registrar")
    @ResponseBody
    public ResultadoResponse registerProduct(@RequestBody ProductoRequest productRequest) throws Exception {
        String mensaje = "Producto registrado correctamente";
        boolean respuesta = true;
        try {
            Producto product = new Producto();

            if (productRequest.getId() > 0) {
                product.setId(productRequest.getId());
            }
            product.setNombre(productRequest.getNombre());
            product.setPrecio(productRequest.getPrecio());
            product.setCreateAt(productRequest.getCreateAt());
            product.setActivo(productRequest.getActivo());
            product.setStock(productRequest.getStock());
            iProductService.registerProductos(product);

        } catch (Exception ex) {
            mensaje = "Producto no registrado, error en la BD.";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        iProductService.eliminarProducto(id);
        return "redirect:/producto";
    }
}
