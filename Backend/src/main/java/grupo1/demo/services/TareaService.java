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
import grupo1.demo.models.Tarea;
import grupo1.demo.repositories.TareaRepository;
@RestController
@CrossOrigin(origins = "*")
public class TareaService {
    private final TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    
    @GetMapping("/tareas/count")
    public String countTareas() {
        int total = tareaRepository.countTareas();
        return String.format("existen %s tareas", total);
    }

    // Create
    @PostMapping("/tareas/create")
    @ResponseBody
    public String createTarea(@RequestBody Tarea tarea) {
        return tareaRepository.createTarea(tarea);
    }
    
    // Read all
    @GetMapping("/tareas")
    public List<Tarea> getAllTareas() {
        return tareaRepository.getAllTareas();
    }

    // uUPODATE
    @PostMapping("/tareas/updateTarea")
    @ResponseBody
    public String updateTarea(@RequestBody Tarea tarea) {
        return tareaRepository.updateTarea(tarea);
    }
    // Delete
    @DeleteMapping("/tarea/delete/{id}")
    @ResponseBody
    public boolean deleteTarea(@PathVariable int id) {
        return tareaRepository.deleteTarea(id);
    }
}
