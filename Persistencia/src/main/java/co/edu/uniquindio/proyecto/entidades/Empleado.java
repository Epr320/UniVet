package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Empleado extends Persona{

    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @OneToMany(mappedBy = "empleado")
    private List<Historial> historial;
    public Empleado(String cedula, String nombre, String email, String password, int codigo) {
        super(cedula, nombre, email, password);
        this.codigo = codigo;
    }
}
