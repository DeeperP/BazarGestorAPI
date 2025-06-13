package com.example.BazarGestorAPI.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;

    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "codigo_venta"), //relaciona datos dentro de la tabla
            inverseJoinColumns = @JoinColumn(name = "codigo_producto") //relaciona datos provenientes de otra
    )
    private List<Producto> listaProductos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta,
                 Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
}
