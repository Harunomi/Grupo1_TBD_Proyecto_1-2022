package grupo1.demo.models;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.*;
@EntityScan

public class Tarea_Estado {
    
    // atributos
    private Integer id;
    private Integer id_tarea;
    private Integer id_estado;


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
    public Integer getId_estado() {
        return id_estado;
    }
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

}   


