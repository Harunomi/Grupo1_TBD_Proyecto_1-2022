package grupo1.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;
import java.util.List;

import grupo1.demo.models.Tarea_Habilidad;
@Repository
public class Tarea_HabilidadRepositoryImp implements Tarea_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTarea_Habilidad() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea_Habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createTarea_Habilidad(Tarea_Habilidad tarea_Habilidad) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO tarea_Habilidad(id_TareaHabilidad, id_Tarea, id_Habilidad)" + 
            "VALUES(:id_TareaHabilidad, :id_Tarea, :id_Habilidad)";
            int idTarea_Habilidad = countTarea_Habilidad() + 1;
            conn.createQuery(sql)
                .addParameter("id_tareaHabilidad",idTarea_Habilidad)
                .addParameter("id_tarea",tarea_Habilidad.getId_tarea())
                .addParameter("id_Habilidad",tarea_Habilidad.getId_habilidad())
                .executeUpdate();
            tarea_Habilidad.setId(idTarea_Habilidad);
            
            return "Se ha creado la tarea_Habilidad con la id : " + idTarea_Habilidad;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_Habilidad> getAllTarea_Habilidad() {
        String sql = "SELECT * FROM Tarea_Habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateTarea_Habilidad(Tarea_Habilidad tarea_Habilidad) {
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO tarea_Habilidad(id_TareaHabilidad, id_Tarea, id_Habilidad)" + 
            "VALUES(:id_TareaHabilidad, :id_Tarea, :id_Habilidad)";
            conn.createQuery(sql)
                .addParameter("id_tareaHabilidad",tarea_Habilidad.getId())
                .addParameter("id_tarea",tarea_Habilidad.getId_tarea())
                .addParameter("id_Habilidad",tarea_Habilidad.getId_habilidad())
                .executeUpdate();
            tarea_Habilidad.setId(tarea_Habilidad.getId());
            
            return "Se ha editado la tarea_Habilidad.";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTarea_Habilidad(int id) {
        String sql = "DELETE FROM tarea_Habilidad WHERE id_TareaHabilidad = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id_TareaHabilidad", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
