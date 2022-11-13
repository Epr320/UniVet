package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.entidades.Hospitalizacion;
import co.edu.uniquindio.proyecto.interfaces.HospitalizacionServicio;
import co.edu.uniquindio.proyecto.repositorios.HospitalizacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizacionServicioImpl implements HospitalizacionServicio {

    @Autowired
    HospitalizacionRepo hospitalizacionRepo;

    @Override
    public List<Hospitalizacion> verHospitalizacionesDeMacotas(String cedulaCliente) {
        return hospitalizacionRepo.verHospitalizaciones(cedulaCliente);
    }
}
