package com.example.BazarGestorAPI.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaMayorDTO {
    private Long codigo_venta;
    private Double total;
    private String nombre, apellido;
    private int cantProductos;

    public VentaMayorDTO() {
    }

    public VentaMayorDTO(Long codigo_venta, Double total, String nombre, String apellido, int cantProductos) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cantProductos = cantProductos;
    }

}
