package com.example.BazarGestorAPI.Service;

import com.example.BazarGestorAPI.Entity.Producto;
import com.example.BazarGestorAPI.Entity.Venta;
import com.example.BazarGestorAPI.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> listarTodos() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> buscarPorId(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        ventaRepository.deleteById(id);
    }

    /**
     * Se utiliza Optional para evitar errores si no se encuentra la venta con el ID especificado.
     *  - Si la venta existe, se devuelve su lista de productos.
     *  - Si no existe, se lanza una excepción con un mensaje claro.
     *  Esto evita NullPointerException y mejora el manejo de errores.
     *  Se usa .isPresent() para verificar si el Optional contiene una instancia de Venta.
     *  En caso afirmativo, se obtiene la venta y su lista de productos.
     * Si no hay venta con el ID especificado, se lanza una excepción para evitar errores de ejecución.
     */
    @Override
    public List<Producto> traerProducVenta(Long idVenta){
        Optional<Venta> ventaOpt = ventaRepository.findById(idVenta);
        if (ventaOpt.isPresent()) {
            return ventaOpt.get().getListaProductos();
        } else {
            throw new RuntimeException("Venta no encontrada con id " + idVenta);
        }
    }

    @Override
    public Double totalVentasDelDia(LocalDate fecha) {
        return ventaRepository.obtenerTotalVentasPorFecha(fecha);
    }

    @Override
    public VentaMayorDTO obtenerVentaMayor(){
        Venta venta = ventaRepository.findVentaConMayorTotal().orElseThrow(() -> new RuntimeException("No hay ventas"));

        int cantProduct = venta.getListaProductos().size();

        // 3. Creamos y devolvemos un DTO con los datos necesarios:
        //    - Código de venta
        //    - Total de la venta
        //    - Nombre del cliente
        //    - Apellido del cliente
        //    - Cantidad de productos vendidos
        return new VentaMayorDTO(
                venta.getCodigo_venta(),               // ID o código único de la venta
                venta.getTotal(),                      // Monto total de la venta
                venta.getUnCliente().getNombre(),      // Nombre del cliente asociado
                venta.getUnCliente().getApellido(),    // Apellido del cliente
                cantProduct                            // Cantidad de productos en la venta
        );
    }
}
