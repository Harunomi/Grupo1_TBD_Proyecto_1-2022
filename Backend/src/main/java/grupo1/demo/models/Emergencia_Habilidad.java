package grupo1.demo.models;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;
@EntityScan

public class Emergencia_Habilidad {
    
    //atributos
    private Integer id;
    private Integer id_emergencia;
    private Integer id_habilidad;

    // metodos
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_emergencia() {
        return id_emergencia;
    }
    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    public Integer getId_habilidad() {
        return id_habilidad;
    }
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}


