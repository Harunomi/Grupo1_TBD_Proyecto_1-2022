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

import grupo1.demo.models.Voluntario;
import grupo1.demo.repositories.VoluntarioRepository;

@RestController
@CrossOrigin(origins = "*")
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    
    @GetMapping("/voluntarios/count")
    public String countVoluntarios() {
        int total = voluntarioRepository.countVoluntarios();
        return String.format("existen %s voluntarios", total);
    }

    // Create
    @PostMapping("/voluntarios/create")
    @ResponseBody
    public String createVoluntario(@RequestBody Voluntario voluntario) {
        return voluntarioRepository.createVoluntario(voluntario);
    }
    
    // Read all
    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.getAllVoluntarios();
    }

    // uUPODATE
    @PostMapping("/voluntarios/updateVoluntario")
    @ResponseBody
    public String updateVoluntario(@RequestBody Voluntario voluntario) {
        return voluntarioRepository.updateVoluntario(voluntario);
    }
    // Delete
    @DeleteMapping("/voluntarios/delete/{id}")
    @ResponseBody
    public boolean deleteVoluntario(@PathVariable int id) {
        return voluntarioRepository.deleteVoluntario(id);
    }
}
