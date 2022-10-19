package co.edu.uniquindio.proyecto.interfaces;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Cliente;

public interface ClienteServicio {
    Cliente login (String email, String password) throws Exception;
    Cliente registarCliente(Cliente cliente)throws Exception;

    Cliente obtenerCliente(String cedula);
}
