package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Hospitalizacion;
import co.edu.uniquindio.proyecto.interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.interfaces.HospitalizacionServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class HistorialHospitalizacionBean {
    @Value("#{param['cedula']}")
    private String cedula;

    @Getter
    @Setter
    Cliente cliente;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    HospitalizacionServicio hospitalizacionServicio;

    @Getter @Setter
    private List<Hospitalizacion> hospitalizacions=new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        hospitalizacions=hospitalizacionServicio.verHospitalizacionesDeMacotas(cedula);
        hospitalizacions=hospitalizacions;
    }

}
