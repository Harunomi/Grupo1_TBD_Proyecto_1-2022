package grupo1.demo.repositories;

import grupo1.demo.models.Voluntario;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVoluntarios() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM voluntario";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createVoluntario(Voluntario voluntario){
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO voluntario(id, nombre, correo, contrasenya, edad, ubicacion, id_ranking)" + 
            "VALUES(:id, :nombre, :correo, :contrasenya, :edad, :ubicacion, :id_ranking)";
            int idVoluntario = countVoluntarios() + 1;
            conn.createQuery(sql)
                .addParameter("id",idVoluntario)
                .addParameter("nombre",voluntario.getNombre())
                .addParameter("correo",voluntario.getCorreo())
                .addParameter("contrasenya",voluntario.getContrasenya())
                .addParameter("edad",voluntario.getEdad())
                .addParameter("ubicacion",voluntario.getUbicacion())
                .addParameter("id_ranking",voluntario.getId_ranking())
                .executeUpdate();
            voluntario.setId(idVoluntario);
            
            return "Se ha creado un voluntario con la id : " + idVoluntario;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> getAllVoluntarios() {
        String sql = "SELECT * FROM Voluntario";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteVoluntario(int id) {
        String sql = "DELETE FROM voluntario WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String updateVoluntario(Voluntario voluntario){
        try(Connection conn = sql2o.open()){
            String sql = "INSER INTO voluntario(id, nombre, correo, contrasenya, edad, ubicacion, id_ranking)" + 
            "VALUES(:id, :nombre, :correo, :contrasenya, :edad, :ubicacion, :id_ranking)";
            conn.createQuery(sql)
                .addParameter("id",voluntario.getId())
                .addParameter("nombre",voluntario.getNombre())
                .addParameter("correo",voluntario.getCorreo())
                .addParameter("contrasenya",voluntario.getContrasenya())
                .addParameter("edad",voluntario.getEdad())
                .addParameter("ubicacion",voluntario.getUbicacion())
                .addParameter("id_ranking",voluntario.getId_ranking())
                .executeUpdate();
            voluntario.setId(voluntario.getId());
            
            return "Se ha modificado el Voluntario";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
