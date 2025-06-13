package com.example.BazarGestorAPI.Service;

import com.example.BazarGestorAPI.Entity.Producto;
import com.example.BazarGestorAPI.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> traerLess5(){
        return productoRepository.findBycantidadDisponibleLessThan(5.0);
    }

}

