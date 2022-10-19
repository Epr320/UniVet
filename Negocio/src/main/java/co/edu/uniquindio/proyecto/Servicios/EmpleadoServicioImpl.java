package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.interfaces.EmpleadoServicio;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
    @Autowired
    EmpleadoRepo empleadoRepo;

    @Override
    public Empleado login(String email, String password) throws Exception {
        return empleadoRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception("Datos Incorrectos"));

    }
}
