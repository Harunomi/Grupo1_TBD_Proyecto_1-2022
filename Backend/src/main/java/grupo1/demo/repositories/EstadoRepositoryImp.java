package grupo1.demo.repositories;
import grupo1.demo.models.Estado;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository

public class EstadoRepositoryImp implements EstadoRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstados() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM estado";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }
    
    @Override
    public List<Estado> getAllEstados() {
        String sql = "SELECT * FROM estado";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Estado.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public String createEstado(Estado estado) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO estado(id, nombre)" +
                    "VALUES(:id, :nombre)";
            int idEstado = countEstados() + 1;
            conn.createQuery(sql)
                    .addParameter("id", idEstado)
                    .addParameter("nombre", estado.getNombre())
                    .executeUpdate();
            estado.setId(idEstado);

            return "Se ha creado el estado con id: " + idEstado;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public boolean deleteEstado(int id) {
        String sql = "DELETE FROM estado WHERE id = :id";
        try (Connection conn = sql2o.open()) {
           conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    @Override
    public String updateEstado(Estado estado) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO estado(id, nombre)" +
                    "VALUES(:id, :nombre)";
            int idEstado = countEstados() + 1;
            conn.createQuery(sql)
                    .addParameter("id", idEstado)
                    .addParameter("nombre", estado.getNombre())
                    .executeUpdate();
            estado.setId(estado.getId());

            return "Se ha editado el estado";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
