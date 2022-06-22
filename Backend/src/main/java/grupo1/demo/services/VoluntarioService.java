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
import org.springframework.web.bind.annotation.*;

import grupo1.demo.models.Voluntario;
import grupo1.demo.repositories.VoluntarioRepository;

@CrossOrigin(origins = "*")
@RestController
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
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        System.out.println("getAllVoluntarios()");
        try {
            List<Voluntario> voluntarios = voluntarioRepository.getAllVoluntarios();
            System.out.println("1");
            for (Voluntario v : voluntarios) {
                System.out.println("ID: " + v.getId());
            }
            System.out.println("2");
            return voluntarios;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        }
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
