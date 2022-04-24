package grupo1.demo.repositories;
import grupo1.demo.models.Emergencia_Habilidad;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;
@Repository
public class Emergencia_HabilidadRepositoryImp implements Emergencia_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEmergencia_Habilidad(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergencia_habilidad";
        try (Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);

        }
        return total;
    }

    @Override
    public String createEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO emergencia_habilidad(id, id_emergencia, id_habilidad)" + 
            "VALUES(:id, :id_emergencia, :id_habilidad)";
            int idEmergencia_Habilidad = countEmergencia_Habilidad() + 1;
            conn.createQuery(sql)
                .addParameter("id",idEmergencia_Habilidad)
                .addParameter("id_emergencia",emergencia_habilidad.getId_emergencia())
                .addParameter("id_habilidad",emergencia_habilidad.getId_habilidad())
                .executeUpdate();
            emergencia_habilidad.setId(idEmergencia_Habilidad);

            return "Se ha creado una emergencia_habilidad con la id: " + idEmergencia_Habilidad;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergencia_Habilidad> getAllEmergencia_Habilidad() {
        String sql = "SELECT * FROM Emergencia_Habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteEmergencia_Habilidad(int id) {
        String sql = "DELETE FROM emergencia_habilidad WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String updateEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO emergencia_habilidad(id, id_emergencia, id_habilidad)" + 
            "VALUES(:id, :id_emergencia, :id_habilidad)";
            conn.createQuery(sql)
                .addParameter("id",emergencia_habilidad.getId())
                .addParameter("id_emergencia",emergencia_habilidad.getId_emergencia())
                .addParameter("id_habilidad",emergencia_habilidad.getId_habilidad())
                .executeUpdate();
            emergencia_habilidad.setId(emergencia_habilidad.getId());

            return "Se ha editado la emergencia_habilidad.";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
