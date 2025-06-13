package com.example.BazarGestorAPI.Repository;

import com.example.BazarGestorAPI.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCantidadDisponibleLessThan(Double cantidad);
}
