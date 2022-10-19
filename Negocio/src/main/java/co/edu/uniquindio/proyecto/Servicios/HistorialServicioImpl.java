package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Historial;
import co.edu.uniquindio.proyecto.interfaces.HistorialServicio;
import co.edu.uniquindio.proyecto.repositorios.HistorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialServicioImpl implements HistorialServicio {
    @Autowired
    HistorialRepo historialRepo;

    @Override
    public Historial agregarHistorial(Historial historial) {
        return historialRepo.save(historial);
    }
}
