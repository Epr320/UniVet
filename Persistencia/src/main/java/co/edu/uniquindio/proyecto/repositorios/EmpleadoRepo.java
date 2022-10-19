package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado,String> {

    Optional<Empleado> findByEmailAndPassword(String email, String password);

    Optional<Empleado> findByEmail(String email);

}
