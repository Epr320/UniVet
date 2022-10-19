package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Resenia;
import co.edu.uniquindio.proyecto.interfaces.ReseniaServicio;
import co.edu.uniquindio.proyecto.repositorios.ReseniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServicioImpl implements ReseniaServicio {
    @Autowired
    ReseniaRepo reseniaRepo;

    @Override
    public Resenia crearResenia(Resenia resenia) {
        return reseniaRepo.save(resenia);
    }

    @Override
    public List<Resenia> listarResenias() {
        return reseniaRepo.findAll();
    }
}
