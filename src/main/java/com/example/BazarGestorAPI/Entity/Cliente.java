package com.example.BazarGestorAPI.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre, apellido, dni;

    @OneToMany(mappedBy = "unCliente")
    private List<Venta> ventas;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

}

