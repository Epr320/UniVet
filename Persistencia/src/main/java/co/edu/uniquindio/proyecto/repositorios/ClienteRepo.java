package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByEmailAndPassword(String email, String Password);

    Optional<Cliente> findByEmail(String email);

}
