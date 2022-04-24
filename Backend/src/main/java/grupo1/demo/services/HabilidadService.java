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

import grupo1.demo.models.Habilidad;
import grupo1.demo.repositories.HabilidadRepository;


@RestController
@CrossOrigin(origins = "*")

public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    HabilidadService(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    
    @GetMapping("/habilidades/count")
    public String countHabilidades() {
        int total = habilidadRepository.countHabilidades();
        return String.format("existen %s habilidades", total);
    }

    // Create
    @PostMapping("/habilidades/create")
    @ResponseBody
    public String createHabilidad(@RequestBody Habilidad habilidad) {
        return habilidadRepository.createHabilid(habilidad);
    }
    
    // Read all
    @GetMapping("/habilidades")
    public List<Habilidad> getAllHabilidades() {
        return habilidadRepository.getAllHabilidades();
    }

    // uUPODATE
    @PostMapping("/habilidades/updateHabilidad")
    @ResponseBody
    public String updateHabilidad(@RequestBody Habilidad habilidad) {
        return habilidadRepository.updateHabilidad(habilidad);
    }
    // Delete
    @DeleteMapping("/habilidades/delete/{id}")
    @ResponseBody
    public boolean deleteHabilidad(@PathVariable int id) {
        return habilidadRepository.deleteHabilidad(id);
    }
}
