package grupo1.demo.repositories;

import java.util.List;

import grupo1.demo.models.Tarea;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;
public class TareaRepositoryImp implements TareaRepository{

    @Override
    public int countTareas() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM tarea";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO tarea(id, descripcion, nombre)" +
                    "VALUES(:id, :descripcion, :nombre)";
            int idTarea = countTareas() + 1;
            int zero =0;
            conn.createQuery(sql)
                    .addParameter("id", idTarea)
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("tarea", tarea.getNombre())
                    .executeUpdate();

            tarea.setId(idTarea);

            return "Se ha creado la tarea con id: " + idTarea;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getAllTareas() {
        String sql = "SELECT * FROM Tarea";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateTarea(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO tarea(id, descripcion, nombre)" +
                    "VALUES(:id, :descripcion, :nombre)";
            int zero =0;
            conn.createQuery(sql)
                    .addParameter("id", tarea.getId())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("tarea", tarea.getNombre())
                    .executeUpdate();


            tarea.setId(tarea.getId());

            return "Se ha editado la tarea ";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteTarea(int id) {
        String sql = "DELETE FROM tarea WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
