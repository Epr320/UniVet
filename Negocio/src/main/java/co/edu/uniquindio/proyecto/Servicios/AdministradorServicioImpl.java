package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImpl implements AdministradorServicio {

    @Autowired
    AdministradorRepo administradorRepo;

    @Override
    public Administrador login(String email, String password) throws Exception {
        return administradorRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception("Datos Incorrectos"));
    }
}
