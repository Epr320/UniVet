package co.edu.uniquindio.proyecto.Bean;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Cliente;
import co.edu.uniquindio.proyecto.entidades.Empleado;
import co.edu.uniquindio.proyecto.entidades.Historial;
import co.edu.uniquindio.proyecto.interfaces.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@ViewScoped
public class IniciarSesionBean implements Serializable {

    @Getter
    @Value("#{param['cedula']}")
    private String cedula;

    @Getter
    @Setter
    private String correo;

    @Getter @Setter
    private String contraseña;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private HistorialServicio historialServicio;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private PersonaServicio personaServicio;

    public String iniciarSesion() {
        int tipoPersona= 0;
        try {
            tipoPersona = personaServicio.verificarTipoDeUsuario(correo);
            if(tipoPersona==3){
                Cliente cliente=clienteServicio.login(correo,contraseña);
                return "cliente_index?faces-redirect=true&amp;cedula="+cliente.getCedula();
            }
            if(tipoPersona==2){
                Empleado empleado = empleadoServicio.login(correo,contraseña);
                Historial historial=new Historial();
                historial.setEmpleado(empleado);
                historial.setDate(LocalDateTime.now());
                historialServicio.agregarHistorial(historial);
                return "empleado_index.xhtml?faces-redirect=true&amp;cedula="+empleado.getCedula();
            }
            if(tipoPersona==1){
                Administrador administrador = administradorServicio.login(correo,contraseña);
                return "administrador_index.xhtml?faces-redirect=true&amp;cedula="+administrador.getCedula();
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


        return null;
    }
    public String registarCliente(){
        return "RegistrarUsuario.xhtml?faces-redirect=true&amp";
    }
    public String CrearResenia(){
        return "Resenias?faces-redirect=true&amp;cedula="+cedula;
    }
}
