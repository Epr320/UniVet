package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.interfaces.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;


@Component
@ViewScoped
public class ClienteIndexBean implements Serializable {

    @Value("#{param['cedular']}")
    private String cedula;

    @Getter @Setter
    Cliente cliente;

    @Autowired
    ClienteServicio clienteServicio;

    @PostConstruct
    public void inicializar() {

    }
    public String CrearResenia(){
        return "Resenias?faces-redirect=true&amp;cedula="+cedula;
    }

    public String VerManual(){
        return "manual?faces-redirect=true&amp;";
    }
}
