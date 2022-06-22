package grupo1.demo.models;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;

@EntityScan
public class Emergencia {

    // atributos
    private String titulo;
    private Integer maximo_voluntario;
    private Integer voluntarios;
    private String descripcion;
    private Integer id;
    private Integer id_institucion;
    private double latitude;
    private double longitude;

    // metodos
    public Integer getId_institucion() {
        return id_institucion;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

    public Integer getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(Integer voluntarios) {
        this.voluntarios = voluntarios;
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
