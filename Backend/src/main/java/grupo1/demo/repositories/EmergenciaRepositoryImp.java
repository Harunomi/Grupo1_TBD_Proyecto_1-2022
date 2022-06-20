package grupo1.demo.repositories;

import grupo1.demo.models.Emergencia;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEmergencias() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM emergencia";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createEmergencia(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO emergencia(id, titulo, maximo_voluntario, voluntarios, descripcion, id_institucion, location)"
                    +
                    "VALUES(:id, :titulo, :maximo_voluntario, :voluntarios, :descripcion, :id_institucion, ST_GeomFromText(:point, 4326))";
            int idEmergencia = countEmergencias() + 1;
            String point = "POINT(" + emergencia.getLongitude() + " " + emergencia.getLatitude() + ")";
            conn.createQuery(sql)
                    .addParameter("id", idEmergencia)
                    .addParameter("titulo", emergencia.getTitulo())
                    .addParameter("voluntarios", 0)
                    .addParameter("maximo_voluntario", emergencia.getMaximo_voluntario())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .addParameter("point", point)
                    .executeUpdate();
            emergencia.setId(idEmergencia);

            return "Se ha creado una emergencia :D con la id : " + idEmergencia;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        String sql = "SELECT * FROM Emergencia";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteEmergencia(int id) {
        String sql = "DELETE FROM emergencia WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String updateEmergencia(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSER INTO emergencia(id, titulo, maximo_voluntario, voluntarios, descripcion, id_institucion, location)"
                    +
                    "VALUES(:id, :titulo, :maximo_voluntario, :voluntarios, :descripcion, :id_institucion, ST_GeomFromText(:point, 4326))";
            String point = "POINT(" + emergencia.getLongitude() + " " + emergencia.getLatitude() + ")";
            conn.createQuery(sql)
                    .addParameter("id", emergencia.getId())
                    .addParameter("titulo", emergencia.getTitulo())
                    .addParameter("maximo_voluntario", emergencia.getMaximo_voluntario())
                    .addParameter("voluntarios", emergencia.getVoluntarios())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .addParameter("point", point)
                    .executeUpdate();
            emergencia.setId(emergencia.getId());

            return "Se ha editado la emergencia.";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
