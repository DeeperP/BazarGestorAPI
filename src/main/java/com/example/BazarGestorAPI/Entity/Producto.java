package com.example.BazarGestorAPI.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre, marca;
    private Double costo, cantidad_disponible;

    @ManyToMany(mappedBy = "listaProductos")
    private List<Venta> ventas;
    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }

}
