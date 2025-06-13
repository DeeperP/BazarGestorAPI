package com.example.BazarGestorAPI.Service;

import com.example.BazarGestorAPI.DTO.VentaMayorDTO;
import com.example.BazarGestorAPI.Entity.Producto;
import com.example.BazarGestorAPI.Entity.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVentaService {
    List<Venta> listarTodos();
    Venta guardar(Venta venta);
    Optional<Venta> buscarPorId(Long id);
    void eliminarPorId(Long id);

    List<Producto> traerProducVenta(Long idVenta);

    Double totalVentasDelDia(LocalDate fecha);

    VentaMayorDTO obtenerVentaMayor();
}
