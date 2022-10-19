package co.edu.uniquindio.proyecto.interfaces;

import co.edu.uniquindio.proyecto.entidades.Administrador;

public interface AdministradorServicio {
    Administrador login (String email, String password) throws Exception;
}
