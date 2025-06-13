package com.example.BazarGestorAPI.Controller;

import com.example.BazarGestorAPI.DTO.VentaMayorDTO;
import com.example.BazarGestorAPI.Entity.Producto;
import com.example.BazarGestorAPI.Entity.Venta;
import com.example.BazarGestorAPI.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // POST - Crear venta
    @PostMapping("/crear")
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }

    // GET - Listar todas las ventas
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.listarTodos();
    }

    // GET - Traer una venta por ID
    @GetMapping("/{id_venta}")
    public Optional<Venta> obtenerVenta(@PathVariable Long id_venta) {
        return ventaService.buscarPorId(id_venta);
    }

    // DELETE - Eliminar una venta
    @DeleteMapping("/eliminar/{id_venta}")
    public void eliminarVenta(@PathVariable Long id_venta) {
        ventaService.eliminarPorId(id_venta);
    }

    // GET - Traer productos de una venta
    @GetMapping("/productos/{id_venta}")
    public List<Producto> productosDeVenta(@PathVariable Long id_venta) {
        return ventaService.traerProducVenta(id_venta);
    }

    // GET - Total de ventas en una fecha
    @GetMapping("/total/{fecha}")
    public Double totalVentasDelDia(@PathVariable String fecha) {
        LocalDate fechaParseada = LocalDate.parse(fecha);
        return ventaService.totalVentasDelDia(fechaParseada);
    }

    // GET - Venta con el mayor total
    @GetMapping("/mayor")
    public VentaMayorDTO ventaConMayorTotal() {
        return ventaService.obtenerVentaMayor();
    }
}
