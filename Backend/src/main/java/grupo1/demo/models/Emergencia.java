package grupo1.demo.models;


import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;

@EntityScan
public class Emergencia {

    // atributos
    private String titulo;
    private String ubicacion_emergencia;
    private Integer maximo_voluntario;
    private String descripcion;
    private Integer id;
    private Integer id_institucion;

    // metodos
    public Integer getId_institucion() {
        return id_institucion;
    }
    public void setId_institucion(Integer id_institucion) {
        this.id_institucion = id_institucion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getUbicacion_emergencia() {
        return ubicacion_emergencia;
    }
    public void setUbicacion_emergencia(String ubicacion_emergencia) {
        this.ubicacion_emergencia = ubicacion_emergencia;
    }
    public Integer getMaximo_voluntario() {
        return maximo_voluntario;
    }
    public void setMaximo_voluntario(Integer maximo_voluntario) {
        this.maximo_voluntario = maximo_voluntario;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    
    
}   

