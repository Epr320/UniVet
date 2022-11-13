package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.interfaces.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;


@Component
@ViewScoped
public class ClienteIndexBean implements Serializable {

    @Value("#{param['cedula']}")
    private String cedula;

    @Getter @Setter
    Cliente cliente;

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    IniciarSesionBean iniciarSesionBean;

    @PostConstruct
    public void inicializar() {
       // clienteServicio.obtenerCliente(cedula);
    }
    public String CrearResenia(){
        return "Resenias?faces-redirect=true&amp;cedula="+cedula;
    }
    public String VerHospitalizaciones(){
        return "historialHospitalizacion?faces-redirect=true&amp;cedula="+cedula;
    }

    public String VerManual(){
        return "manual?faces-redirect=true&amp;";
    }
}
