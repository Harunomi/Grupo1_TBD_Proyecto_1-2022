package grupo1.demo.repositories;

import grupo1.demo.models.Voluntario_Habilidad;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;
@Repository
public class Voluntario_HabilidadRepositoryImp implements Voluntario_HabilidadRepository {
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVoluntario_Habilidad(){
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntario_habilidad";
        try (Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }

        return total;
    }

    @Override
    public String createVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad){
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO voluntario_habilidad(id, id_voluntario, id_habilidad)" +
            "VALUES(:id, :id_voluntario, :id_habilidad)";
            int idVoluntario_Habilidad = countVoluntario_Habilidad() + 1;
            conn.createQuery(sql)
                .addParameter("id",idVoluntario_Habilidad)
                .addParameter("id_voluntario",voluntario_habilidad.getId_voluntario())
                .addParameter("id_habilidad",voluntario_habilidad.getId_habilidad())
                .executeUpdate();
            voluntario_habilidad.setId(idVoluntario_Habilidad);
            
            return "se ha creado un nuevo Voluntario_Habilidad con la id: " + idVoluntario_Habilidad;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad() {
        String sql = "SELECT * FROM Voluntario_Habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteVoluntario_Habilidad(int id) {
        String sql = "DELETE FROM voluntario_habilidad WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String updateVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad){
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO voluntario_habilidad(id, id_voluntario, id_habilidad)" +
            "VALUES(:id, :id_voluntario, :id_habilidad)";
            conn.createQuery(sql)
                .addParameter("id",voluntario_habilidad.getId())
                .addParameter("id_voluntario",voluntario_habilidad.getId_voluntario())
                .addParameter("id_habilidad",voluntario_habilidad.getId_habilidad())
                .executeUpdate();
            voluntario_habilidad.setId(voluntario_habilidad.getId());
            
            return "se ha editado el voluntario_habilidad";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
