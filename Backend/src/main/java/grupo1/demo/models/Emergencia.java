package grupo1.demo.models;


import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;

@EntityScan
public class Emergencia {

    // atributos
    private String titulo;
    private String UbicacionEmergencia;
    private Integer MaximoVoluntarios;
    private String Descripcion;
    private Integer id;


    // metodos
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getUbicacionEmergencia() {
        return UbicacionEmergencia;
    }
    public void setUbicacionEmergencia(String ubicacionEmergencia) {
        UbicacionEmergencia = ubicacionEmergencia;
    }
    public Integer getMaximoVoluntarios() {
        return MaximoVoluntarios;
    }
    public void setMaximoVoluntarios(Integer maximoVoluntarios) {
        MaximoVoluntarios = maximoVoluntarios;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}   

