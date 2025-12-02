package com.techlab.backend.services;

import com.techlab.backend.models.Producto;
import com.techlab.backend.repositories.ProductoRepository;
import com.techlab.backend.utils.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductoService {

  private final ProductoRepository repositorio;

  @Autowired
  public ProductoService(ProductoRepository repositorio) {
    this.repositorio = repositorio;
  }

  public List<Producto> listar(){
    return this.repositorio.findAll();
  }

  public Producto obtenerPorId(Long id){
    return this.repositorio.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Producto con id " + id + " no encontrado"
    ));
  }

  public Producto guardar(Producto producto){
    validarProducto(producto);
    producto.setNombre(Utils.formatearNombreProducto(producto.getNombre()));
    return this.repositorio.save(producto);
  }

  public Producto editar(Long id, Producto producto){
    validarProducto(producto);
    Producto p = obtenerPorId(id);
    p.setNombre(Utils.formatearNombreProducto(producto.getNombre()));
    p.setDescripcion(producto.getDescripcion());
    p.setPrecio(producto.getPrecio());
    p.setStock(producto.getStock());
    return this.repositorio.save(p);
  }

  public void eliminar(Long id){
    if (!repositorio.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          "Producto con id " + id + " no encontrado");
    }
    repositorio.deleteById(id);
  }

  private void validarProducto(Producto producto) {
    if (producto.getNombre() == null || producto.getNombre().isBlank()) {
      throw new IllegalArgumentException("El nombre del producto es obligatorio");
    }
    if (producto.getPrecio() == null || producto.getPrecio() < 0) {
      throw new IllegalArgumentException("El precio es obligatorio y no puede ser negativo");
    }
    if (producto.getStock() == null || producto.getStock() < 0) {
      throw new IllegalArgumentException("El stock es obligatorio y no puede ser negativo");
    }
  }

}
