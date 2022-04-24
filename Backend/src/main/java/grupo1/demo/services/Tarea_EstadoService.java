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
import grupo1.demo.models.Tarea_Estado;
import grupo1.demo.repositories.Tarea_EstadoRepository;

@RestController
@CrossOrigin(origins = "*")
public class Tarea_EstadoService {
    private final Tarea_EstadoRepository tarea_EstadoRepository;

    Tarea_EstadoService(Tarea_EstadoRepository tarea_EstadoRepository) {
        this.tarea_EstadoRepository = tarea_EstadoRepository;
    }

    @GetMapping("/tarea_estado/count")
    public String countTarea_Estado() {
        int total = tarea_EstadoRepository.countTarea_Estado();
        return String.format("existen %s tarea_estado", total);
    }
    // Create
    @PostMapping("/tarea_estado/create")
    @ResponseBody
    public String createTarea_estado(@RequestBody Tarea_Estado tarea_Estado) {
        return tarea_EstadoRepository.createTarea_Estado(tarea_Estado);
    }

    // Read all
    @GetMapping("/tarea_estado")
    public List<Tarea_Estado> getAllTarea_Estado() {
        return tarea_EstadoRepository.getAllTarea_Estado();
    }

    // uUPODATE
    @PostMapping("/tarea_estado/updateTarea_estado")
    @ResponseBody
    public String updateTarea_estado(@RequestBody Tarea_Estado tarea_Estado) {
        return tarea_EstadoRepository.updateTarea_Estado(tarea_Estado);
    }

    // Delete
    @DeleteMapping("/tarea_estado/delete/{id}")
    @ResponseBody
    public boolean deleteTarea_estado(@PathVariable int id) {
        return tarea_EstadoRepository.deleteTarea_Estado(id);
    }
}
