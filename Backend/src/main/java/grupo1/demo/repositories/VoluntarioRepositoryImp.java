package grupo1.demo.repositories;

import grupo1.demo.models.Voluntario;
import grupo1.demo.models.Emergencia;
import grupo1.demo.models.BusquedaVoluntario;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
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
    public String createVoluntario(Voluntario voluntario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO voluntario(id, nombre, correo, edad, ubicacion_geometria)" +
                    "VALUES(:id, :nombre, :correo, :edad, ST_GeomFromText(:point, 4326))";
            int idVoluntario = countVoluntarios() + 1;
            String point = "POINT(" + voluntario.getLongitude() + " " + voluntario.getLatitude() + ")";
            conn.createQuery(sql)
                    .addParameter("id", idVoluntario)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("edad", voluntario.getEdad())
                    .addParameter("point", point)
                    .executeUpdate();
            voluntario.setId(idVoluntario);

            return "Se ha creado un voluntario con la id : " + idVoluntario;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // lectura
    @Override
    public List<Voluntario> getAllVoluntarios() {
        String sql = "SELECT id, nombre, correo, edad, st_x(st_astext(ubicacion_geometria)) AS longitude, st_y(st_astext(ubicacion_geometria)) AS latitude FROM Voluntario";
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
    public String updateVoluntario(Voluntario voluntario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSER INTO voluntario(id, nombre, correo, contrasenya, edad, id_ranking, location)" +
                    "VALUES(:id, :nombre, :correo, :contrasenya, :edad, :id_ranking, ST_GeomFromText(:point, 4326))";

            String point = "POINT(" + voluntario.getLongitude() + " " + voluntario.getLatitude() + ")";
            conn.createQuery(sql)
                    .addParameter("id", voluntario.getId())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("correo", voluntario.getCorreo())
                    .addParameter("contrasenya", voluntario.getContrasenya())
                    .addParameter("edad", voluntario.getEdad())
                    .addParameter("id_ranking", voluntario.getId_ranking())
                    .addParameter("point", point)
                    .executeUpdate();
            voluntario.setId(voluntario.getId());

            return "Se ha modificado el Voluntario";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> obtenerVoluntariosCercanos(BusquedaVoluntario datos) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT v.id, v.nombre, v.correo, v.edad, st_x(st_astext(v.ubicacion_geometria)) AS longitude, st_y(st_astext(v.ubicacion_geometria)) AS latitude FROM Voluntario as v, Emergencia "
                    + "WHERE emergencia.id = :id ORDER BY ST_Distance( emergencia.ubicacion_geometria, v.ubicacion_geometria) ASC LIMIT :cantidad";

            return conn.createQuery(sql)
                    .addParameter("cantidad", datos.getCantidad())
                    .addParameter("id", datos.getId())
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
