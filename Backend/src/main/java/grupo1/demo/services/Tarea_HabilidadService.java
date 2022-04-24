package grupo1.demo.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import grupo1.demo.models.Tarea_Habilidad;
import grupo1.demo.repositories.Tarea_HabilidadRepository;

@RestController
@CrossOrigin(origins = "*")
public class Tarea_HabilidadService {
    private final Tarea_HabilidadRepository tarea_HabilidadRepository;

    Tarea_HabilidadService(Tarea_HabilidadRepository tarea_HabilidadRepository) {
        this.tarea_HabilidadRepository = tarea_HabilidadRepository;
    }

    @GetMapping("/tarea_Habilidad/count")
    public String countTarea_Habilidad() {
        int total = tarea_HabilidadRepository.countTarea_Habilidad();
        return String.format("existen %s tarea_Habilidad", total);
    }
    // Create
    @PostMapping("/tarea_Habilidad/create")
    @ResponseBody
    public String createTarea_Habilidad(@RequestBody Tarea_Habilidad tarea_Habilidad) {
        return tarea_HabilidadRepository.createTarea_Habilidad(tarea_Habilidad);
    }

    // Read all
    @GetMapping("/tarea_Habilidad")
    public List<Tarea_Habilidad> getAllTarea_Habilidad() {
        return tarea_HabilidadRepository.getAllTarea_Habilidad();
    }

    // uUPODATE
    @PostMapping("/tarea_Habilidad/updateTarea_Habilidad")
    @ResponseBody
    public String updateTarea_Habilidad(@RequestBody Tarea_Habilidad tarea_Habilidad) {
        return tarea_HabilidadRepository.updateTarea_Habilidad(tarea_Habilidad);
    }

    // Delete
    @DeleteMapping("/tarea_Habilidad/delete/{id}")
    @ResponseBody
    public boolean deleteTarea_Habilidad(@PathVariable int id) {
        return tarea_HabilidadRepository.deleteTarea_Habilidad(id);
    }
}
