package grupo1.demo.repositories;

import grupo1.demo.models.Emergencia_Estado;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository
public class Emergencia_estadoRepositoryImp implements Emergencia_EstadoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEmergenciaEstado() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergencia_Estado";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createEmergenciaEstado(Emergencia_Estado emergencia_Estado){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO emergencia_Estado(id, id_emergencia, id_estado)" + 
            "VALUES(:id, :id_emergencia, :id_estado)";
            int idEmergencia_Estado = countEmergenciaEstado() + 1;
            conn.createQuery(sql)
                .addParameter("id",idEmergencia_Estado)
                .addParameter("id_emergencia",emergencia_Estado.getId_emergencia())
                .addParameter("id_estado",emergencia_Estado.getId_estado())
                .executeUpdate();
            emergencia_Estado.setId(idEmergencia_Estado);
            
            return "Se ha creado la emergencia_estado con el id : " + idEmergencia_Estado;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergencia_Estado> getAllEmergenciaEstado() {
        String sql = "SELECT * FROM emergencia_Estado";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia_Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateEmergenciaEstado(Emergencia_Estado emergencia_Estado) {
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO emergencia_Estado(id, id_emergencia, id_estado)" + 
            "VALUES(:id, :id_emergencia, :id_estado)";
            conn.createQuery(sql)
                .addParameter("id",emergencia_Estado.getId())
                .addParameter("id_emergencia",emergencia_Estado.getId_emergencia())
                .addParameter("id_estado",emergencia_Estado.getId_estado())
                .executeUpdate();
            emergencia_Estado.setId(emergencia_Estado.getId());
            
            return "Se ha editado la emergencia_Estado.";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteEmergenciaEstado(int id) {
        String sql = "DELETE FROM emergencia_Estado WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}