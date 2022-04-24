package grupo1.demo.repositories;
import grupo1.demo.models.Habilidad;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class HabilidadRepositorylmp implements HabilidadeRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countHabilidades() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM habilidad";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createHabilidad(Habilidad habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO habilidad(id, nombre)" + 
            "VALUES(:id, :nombre)";
            int idHabilidad = countHabilidades() + 1;
            conn.createQuery(sql)
                .addParameter("id",idHabilidad)
                .addParameter("nombre",habilidad.getNombre())
                .executeUpdate();
            habilidada.setId(idHabilidad);
            
            return "Se ha creado la habilidad con la id : " + idHabilidad;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Habilidad> getAllHabilidades() {
        String sql = "SELECT * FROM Habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteHabilidad(int id) {
        String sql = "DELETE FROM habilidad WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    @Override
    public String updateHabilidad(Habilidad habilidad){
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO habilidad(id, nombre)" + 
            "VALUES(:id, :nombre)";
            conn.createQuery(sql)
                .addParameter("id",habilidad.getId())
                .addParameter("nombre",habilidad.getTitulo())
                .executeUpdate();
            habilidad.setId(habilidad.getId());
            
            return "Se ha editado la habilidad.";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
