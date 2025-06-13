package com.example.BazarGestorAPI.Controller;

import com.example.BazarGestorAPI.Entity.Cliente;
import com.example.BazarGestorAPI.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // POST - Crear cliente
    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    // GET - Listar todos los clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }

    // GET - Traer un cliente en particular
    @GetMapping("/{id_cliente}")
    public Optional<Cliente> obtenerCliente(@PathVariable Long id_cliente) {
        return clienteService.buscarPorId(id_cliente);
    }

    // DELETE - Eliminar un cliente
    @DeleteMapping("/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente) {
        clienteService.eliminarPorId(id_cliente);
    }

    // PUT - Editar un cliente
    @PutMapping("/editar/{id_cliente}")
    public Cliente editarCliente(@PathVariable Long id_cliente, @RequestBody Cliente clienteActualizado) {
        Optional<Cliente> clienteExistenteOpt = clienteService.buscarPorId(id_cliente);
        if (clienteExistenteOpt.isPresent()) {
            Cliente clienteExistente = clienteExistenteOpt.get();

            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setDni(clienteActualizado.getDni());
            // actualizá más campos si es necesario

            return clienteService.guardar(clienteExistente);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id_cliente);
        }
    }
}
