package co.edu.uniquindio.proyecto.interfaces;

import co.edu.uniquindio.proyecto.entidades.Hospitalizacion;

import java.util.List;

public interface HospitalizacionServicio {

    List<Hospitalizacion> verHospitalizacionesDeMacotas(String cedulaCliente);
}
