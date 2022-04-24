package grupo1.demo.services;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import grupo1.demo.models.Emergencia_Estado;
import grupo1.demo.repositories.Emergencia_EstadoRepository;

@RestController
@CrossOrigin(origins = "*")
public class Emergencia_EstadoService {
    private final Emergencia_EstadoRepository emergencia_EstadoRepository;

    Emergencia_EstadoService(Emergencia_EstadoRepository emergencia_EstadoRepository) {
        this.emergencia_EstadoRepository = emergencia_EstadoRepository;
    }

    @GetMapping("/emergencia_estado/count")
    public String countemergencia_Estado() {
        int total = emergencia_EstadoRepository.countEmergenciaEstado();
        return String.format("existen %s emergencia_estado", total);
    }
    // Create
    @PostMapping("/emergencia_estado/create")
    @ResponseBody
    public String createEmergenciaEstado(@RequestBody Emergencia_Estado emergencia_Estado) {
        return emergencia_EstadoRepository.createEmergenciaEstado(emergencia_Estado);
    }

    // Read all
    @GetMapping("/emergencia_estado")
    public List<Emergencia_Estado> getAllEmergenciaEstado() {
        return emergencia_EstadoRepository.getAllEmergenciaEstado();
    }

    // UPDATE
    @PostMapping("/emergencia_estado/updateemergencia_estado")
    @ResponseBody
    public String updateEmergenciaEstado(@RequestBody Emergencia_Estado emergencia_Estado) {
        return emergencia_EstadoRepository.updateEmergenciaEstado(emergencia_Estado);
    }

    // Delete
    @DeleteMapping("/emergencia_estado/delete/{id}")
    @ResponseBody
    public boolean deleteEmergenciaEstado(@PathVariable int id) {
        return emergencia_EstadoRepository.deleteEmergenciaEstado(id);
    }
}
