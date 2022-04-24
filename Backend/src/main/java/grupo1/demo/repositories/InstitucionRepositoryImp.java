package grupo1.demo.repositories;

import grupo1.demo.models.Institucion;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countInstituciones() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM institucion";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createInstitucion(Institucion institucion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO institucion(id, nombre, ubicacion, correo, descripcion, contrasenya)"
                    +
                    "VALUES(:id, :nombre, :ubicacion, :correo, :descripcion, :contrasenya)";
            int idInstitucion = countInstituciones() + 1;
            conn.createQuery(sql)
                    .addParameter("id", idInstitucion)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("ubicacion", institucion.getUbicacion())
                    .addParameter("correo", institucion.getCorreo())
                    .addParameter("descripcion", institucion.getDescripcion())
                    .addParameter("contrasenya", institucion.getContrasenya())
                    .executeUpdate();

            institucion.setId(idInstitucion);

            return "Se ha creado una institucion :D con la id : " + idInstitucion;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institucion> getAllInstituciones() {
        String sql = "SELECT * FROM Institucion";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteInstitucion(int id) {
        String sql = "DELETE FROM institucion WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String updateInstitucion(Institucion institucion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSER INTO institucion(id, nombre, ubicacion, correo, descripcion, contrasenya)"
                    +
                    "VALUES(:id, :nombre, :ubicacion, :correo, :descripcion, :contrasenya)";
            int idInstitucion = countInstituciones() + 1;
            conn.createQuery(sql)
                    .addParameter("id", institucion.getId())
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("ubicacion", institucion.getUbicacion())
                    .addParameter("correo", institucion.getCorreo())
                    .addParameter("descripcion", institucion.getDescripcion())
                    .addParameter("contrasenya", institucion.getContrasenya())
                    .executeUpdate();
            institucion.setId(institucion.getId());
            return "Se ha editado la institucion.";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
