package com.example.BazarGestorAPI.Repository;

import com.example.BazarGestorAPI.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.time.LocalDate;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    /**
     * Consulta personalizada usando JPQL:
     * Se obtiene la suma del total de todas las ventas realizadas en una fecha espec&iacute;fica.
     * - "Venta v": 'Venta' es la entidad y 'v' es un alias (puede tener cualquier nombre).
     * - "v.total": hace referencia al atributo 'total' de la entidad Venta.
     * - ":fecha": es un par&aacute;metro nombrado que se recibe como argumento del m&eacute;todo.
     * Esta consulta se ejecuta autom&aacute;ticamente por Spring Data JPA cuando se llama al metodo.
     */
    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fecha_venta = :fecha")
    Double obtenerTotalVentasPorFecha(@Param("fecha") LocalDate fecha);
}
