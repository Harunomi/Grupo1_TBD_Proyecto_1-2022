package grupo1.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import grupo1.demo.models.Ranking;
import grupo1.demo.repositories.RankingRepository;

@RestController
@CrossOrigin(origins = "*")
public class RankingService {

    private final RankingRepository rankingRepository;

    RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @GetMapping("/rankings/count")
    public String countRankings() {
        int total = rankingRepository.countRankings();
        return String.format("Tienes %s Rankings!", total);
    }

    // Create
    @PostMapping("/rankings/create")
    @ResponseBody
    public String createRanking(@RequestBody Ranking ranking) {
        return rankingRepository.createRanking(ranking);
    }

    // Read all
    @GetMapping("/rankings")
    public List<Ranking> getAllRankings() {
        return rankingRepository.getAllRankings();
    }

    // UPDATE
    @PostMapping("/rankings/updateRanking")
    @ResponseBody
    public String updateRanking(@RequestBody Ranking ranking) {
        return rankingRepository.updateRanking(ranking);
    }

    // Delete
    @DeleteMapping("/rankings/delete/{id}")
    @ResponseBody
    public boolean deleteRanking(@PathVariable int id) {
        return rankingRepository.deleteRanking(id);
    }

}
