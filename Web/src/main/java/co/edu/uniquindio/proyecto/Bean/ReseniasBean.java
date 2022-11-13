package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Resenia;
import co.edu.uniquindio.proyecto.interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.interfaces.ReseniaServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ReseniasBean implements Serializable {

    @Value("#{param['cedula']}")
    private String cedula;
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    ClienteIndexBean clienteIndexBean;
    @Autowired
    private ReseniaServicio reseniaServicio;

    @Setter @Getter
    List<Resenia> resenias;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Resenia resenia;

    @PostConstruct
    public void inicializar() {
        resenia=new Resenia();
        resenias=reseniaServicio.listarResenias();
        cliente=clienteServicio.obtenerCliente(cedula);
    }
    public void crearComentario(){
        try {
            resenia.setCliente(cliente);

            //calificacion.setId(libro.getCalificaciones().size()+1);
            reseniaServicio.crearResenia(resenia);
            resenias.add(resenia);
            resenia = new Resenia();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
