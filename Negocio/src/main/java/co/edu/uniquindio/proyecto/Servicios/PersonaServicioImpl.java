package co.edu.uniquindio.proyecto.Servicios;


import co.edu.uniquindio.proyecto.interfaces.PersonaServicio;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.repositorios.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Autowired
    private EmpleadoRepo empleadoRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public Integer verificarTipoDeUsuario(String email) throws Exception {
        if(administradorRepo.findByEmail(email).isPresent()){
            return 1;
        } else {
            if(empleadoRepo.findByEmail(email).isPresent()){
                return 2;
            } else{
                if(clienteRepo.findByEmail(email).isPresent()){
                    return 3;
                } else{
                    throw new Exception("No existe un usuario de ningun tipo registrado con este email.");
                }
            }
        }
    }
}
