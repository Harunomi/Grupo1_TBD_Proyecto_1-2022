package grupo1.demo.models;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;
@EntityScan

public class Emergencia_Estado {
    
    // atributos
    private Integer id;
    private Integer id_emergencia;
    private Integer id_estado;


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
    public Integer getId_estado() {
        return id_estado;
    }
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

}


