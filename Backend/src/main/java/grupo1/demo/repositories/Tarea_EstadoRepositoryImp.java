package grupo1.demo.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;
import java.util.List;

import grupo1.demo.models.Tarea_Estado;

public class Tarea_EstadoRepositoryImp implements Tarea_EstadoRepository{

    @Override
    public int countTarea_Estado() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea_estado";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createTarea_Estado(Tarea_Estado tarea_Estado) {
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO tarea_estado(id_TareaEstado, id_Tarea, id_Estado)" + 
            "VALUES(:id_TareaEstado, :id_Tarea, :id_Estado)";
            int idTarea_estado = countTarea_Estado() + 1;
            conn.createQuery(sql)
                .addParameter("id_tareaEstado",idTarea_estado)
                .addParameter("id_tarea",tarea_Estado.getId_tarea())
                .addParameter("id_estado",tarea_Estado.getId_estado())
                .executeUpdate();
            tarea_Estado.setId(idTarea_estado);
            
            return "Se ha creado la tarea_estado con la id : " + idTarea_estado;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea_Estado> getAllTarea_Estado() {
        String sql = "SELECT * FROM Tarea_Estado";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea_Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateTarea_Estado(Tarea_Estado tarea_Estado) {
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO tarea_estado(id_TareaEstado, id_Tarea, id_Estado)" + 
            "VALUES(:id_TareaEstado, :id_Tarea, :id_Estado)";
            conn.createQuery(sql)
                .addParameter("id_tareaEstado",tarea_Estado.getId())
                .addParameter("id_tarea",tarea_Estado.getId_tarea())
                .addParameter("id_estado",tarea_Estado.getId_estado())
                .executeUpdate();
            tarea_Estado.setId(tarea_Estado.getId());
            
            return "Se ha editado la tarea_Estado.";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTarea_Estado(int id) {
        String sql = "DELETE FROM tarea_estado WHERE id_TareaEstado = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id_TareaEstado", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
