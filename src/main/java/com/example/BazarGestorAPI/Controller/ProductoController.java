package com.example.BazarGestorAPI.Controller;

import com.example.BazarGestorAPI.Entity.Producto;
import com.example.BazarGestorAPI.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // POST - Crear producto
    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    // GET - Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarTodos();
    }

    // GET - Traer un producto por ID
    @GetMapping("/{id_producto}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id_producto) {
        return productoService.buscarPorId(id_producto);
    }

    // DELETE - Eliminar producto
    @DeleteMapping("/eliminar/{id_producto}")
    public void eliminarProducto(@PathVariable Long id_producto) {
        productoService.eliminarPorId(id_producto);
    }

    // PUT - Editar producto
    @PutMapping("/editar/{id_producto}")
    public Producto editarProducto(@PathVariable Long id_producto, @RequestBody Producto nuevoProducto) {
        Optional<Producto> productoOpt = productoService.buscarPorId(id_producto);
        if (productoOpt.isPresent()) {
            Producto existente = productoOpt.get();
            existente.setNombre(nuevoProducto.getNombre());
            existente.setMarca(nuevoProducto.getMarca());
            existente.setCosto(nuevoProducto.getCosto());
            existente.setCantidadDisponible(nuevoProducto.getCantidadDisponible());
            // Agregar más campos si corresponde
            return productoService.guardar(existente);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id_producto);
        }
    }

    // GET - Productos con stock menor a 5
    @GetMapping("/stock_bajo")
    public List<Producto> productosConStockBajo() {
        return productoService.traerLess5();
    }
}
