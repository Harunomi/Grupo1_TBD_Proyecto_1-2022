package grupo1.demo.models;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;
@EntityScan

public class Tarea_Habilidad {
    
    // atributos
    private Integer id;
    private Integer id_tarea;
    private Integer id_habilidad;

    // metodos
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_tarea() {
        return id_tarea;
    }
    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }
    public Integer getId_habilidad() {
        return id_habilidad;
    }
    public void setId_habilidad(Integer id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}


