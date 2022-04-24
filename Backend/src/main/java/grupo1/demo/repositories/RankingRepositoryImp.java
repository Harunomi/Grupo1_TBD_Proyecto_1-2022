package grupo1.demo.repositories;

import grupo1.demo.models.Ranking;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.*;

@Repository
public class RankingRepositoryImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countRankings() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM ranking";
        try (Connection conn = sql2o.open()) {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public String createRanking(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO ranking(id, descripcion, valor)"
                    +
                    "VALUES(:id, :descripcion, :valor)";
            int idRanking = countRankings() + 1;
            conn.createQuery(sql)
                    .addParameter("id", idRanking)
                    .addParameter("descripcion", ranking.getDescripcion())
                    .addParameter("valor", ranking.getValor())
                    .executeUpdate();
            ranking.setId(idRanking);

            return "Se ha creado un ranking :D con la id : " + idRanking;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Ranking> getAllRankings() {
        String sql = "SELECT * FROM Ranking";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteRanking(int id) {
        String sql = "DELETE FROM ranking WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String updateRanking(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSER INTO emergencia(id, descripcion, valor)"
                    +
                    "VALUES(:id, :descripcion, :valor)";
            conn.createQuery(sql)
                    .addParameter("id", ranking.getId())
                    .addParameter("descripcion", ranking.getDescripcion())
                    .addParameter("valor", ranking.getValor())
                    .executeUpdate();
            ranking.setId(ranking.getId());

            return "Se ha editado el ranking.";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
