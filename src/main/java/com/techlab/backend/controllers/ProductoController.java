package com.techlab.backend.controllers;

import com.techlab.backend.models.Producto;
import com.techlab.backend.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {

  private final ProductoService service;

  @Autowired
  public ProductoController(ProductoService service) {
    this.service = service;
  }

  @GetMapping
  public List<Producto> listarProductos(@RequestParam(required = false, defaultValue = "") String nombre){
    return this.service.listar(nombre);
  }

  @GetMapping("/{id}")
  public Producto obtenerProducto(@PathVariable Long id){
    return this.service.obtenerPorId(id);
  }

  @PostMapping
  public Producto crearProducto(@RequestBody Producto producto){
    return this.service.guardar(producto);
  }

  @PutMapping("/{id}")
  public Producto editarProducto(@PathVariable Long id, @RequestBody Producto producto){
    return this.service.editar(id, producto);
  }

  @DeleteMapping("/{id}")
  public void eliminarProducto(@PathVariable Long id){
    this.service.eliminar(id);
  }
}