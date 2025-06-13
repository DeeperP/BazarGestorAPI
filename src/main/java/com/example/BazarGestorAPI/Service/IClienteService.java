package com.example.BazarGestorAPI.Service;

import com.example.BazarGestorAPI.Entity.Cliente;
import com.example.BazarGestorAPI.Entity.Venta;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> listarTodos();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> buscarPorId(Long id);
    void eliminarPorId(Long id);
}