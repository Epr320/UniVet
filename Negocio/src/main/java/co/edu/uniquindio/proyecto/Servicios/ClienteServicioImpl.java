package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {
    @Autowired
    ClienteRepo clienteRepo;
    @Autowired
    AdministradorRepo administradorRepo;

    @Autowired
    EmpleadoRepo empleadoRepo;

    @Override
    public Cliente login(String email, String password) throws Exception {

        return clienteRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception("Datos Incorrectos"));

    }

    @Override
    public Cliente registarCliente(Cliente cliente) throws Exception {

        Optional<Cliente> buscar = clienteRepo.findById(cliente.getCedula());
        Optional<Administrador> buscar2 = administradorRepo.findById(cliente.getCedula());
        Optional<Empleado> buscar3 = empleadoRepo.findById(cliente.getCedula());

        if (buscar.isPresent() || buscar2.isPresent() || buscar3.isPresent()){
            throw new Exception("La cedula ya esta registrada en el sistema");
        }

        buscar = clienteRepo.findByEmail(cliente.getEmail());
        buscar2 = administradorRepo.findByEmail(cliente.getEmail());
        buscar3 = empleadoRepo.findByEmail(cliente.getEmail());

        if (buscar.isPresent() || buscar2.isPresent() || buscar3.isPresent()){
            throw new Exception("El email ya esta registrado");
        }


        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente obtenerCliente(String cedula) {
        return clienteRepo.getById(cedula);
    }
}
