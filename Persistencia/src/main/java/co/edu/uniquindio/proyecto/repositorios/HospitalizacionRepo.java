package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Hospitalizacion;
import co.edu.uniquindio.proyecto.entidades.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalizacionRepo extends JpaRepository<Hospitalizacion,Integer> {

    @Query("select h from Hospitalizacion  h where h.mascota.cliente.cedula=:cedula")
    List<Hospitalizacion> verHospitalizaciones(String cedula);
}
