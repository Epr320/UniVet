package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Persona implements Serializable {
    @ElementCollection
    private List<String> telefono;

    @OneToMany(mappedBy = "cliente")
    private List<Resenia> resenias;

    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas;
    public Cliente(String cedula, String nombre, String email, String password) {
        super(cedula,nombre,email,password);
    }
}