package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepo extends JpaRepository<Mascota,Integer> {
}
