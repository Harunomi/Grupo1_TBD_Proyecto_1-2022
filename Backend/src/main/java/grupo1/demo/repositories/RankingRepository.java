package grupo1.demo.repositories;

import grupo1.demo.models.Ranking;
import java.util.*;

public interface RankingRepository {

    public int countRankings();

    public String createRanking(Ranking ranking);

    public List<Ranking> getAllRankings();

    public String updateRanking(Ranking ranking);

    public boolean deleteRanking(int id);

}
