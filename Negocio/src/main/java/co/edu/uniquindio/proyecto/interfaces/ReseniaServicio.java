package co.edu.uniquindio.proyecto.interfaces;

import co.edu.uniquindio.proyecto.entidades.Resenia;

import java.util.List;

public interface ReseniaServicio {
    Resenia crearResenia(Resenia resenia);
    List<Resenia> listarResenias();
}
