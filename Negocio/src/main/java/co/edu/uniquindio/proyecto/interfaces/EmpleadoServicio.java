package co.edu.uniquindio.proyecto.interfaces;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Empleado;

public interface EmpleadoServicio {
    Empleado login (String email, String password) throws Exception;
}
