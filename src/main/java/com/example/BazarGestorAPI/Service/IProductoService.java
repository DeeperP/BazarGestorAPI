package com.example.BazarGestorAPI.Service;

import com.example.BazarGestorAPI.Entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> listarTodos();
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id);
    void eliminarPorId(Long id);

    List<Producto> traerLess5();
}
