package grupo1.demo.models;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;
@EntityScan

public class Voluntario_Habilidad {
    
    
    // atributos
    private Integer id;
    private Integer id_voluntario;
    private Integer id_habilidad;


    // metodos
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_voluntario() {
        return id_voluntario;
    }
    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }
    public Integer getId_habilidad() {
        return id_habilidad;
    }
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}


