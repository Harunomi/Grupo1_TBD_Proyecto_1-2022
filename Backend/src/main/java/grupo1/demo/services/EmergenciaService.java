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

import grupo1.demo.models.Emergencia;
import grupo1.demo.repositories.EmergenciaRepository;

@RestController
@CrossOrigin(origins = "*")
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    EmergenciaService(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencias/count")
    public String countEmergencias() {
        int total = emergenciaRepository.countEmergencias();
        return String.format("Tienes %s Emergencias!", total);
    }

    // Create
    @PostMapping("/emergencias/create")
    @ResponseBody
    public String createEmergencia(@RequestBody Emergencia emergencia) {
        return emergenciaRepository.createEmergencia(emergencia);
    }

    // Read all
    @GetMapping("/emergencias")
    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.getAllEmergencias();
    }

    // UPDATE
    @PostMapping("/emergencias/updateEmergencia")
    @ResponseBody
    public String updateEmergencia(@RequestBody Emergencia emergencia) {
        return emergenciaRepository.updateEmergencia(emergencia);
    }

    // Delete
    @DeleteMapping("/emergencias/delete/{id}")
    @ResponseBody
    public boolean deleteEmergencia(@PathVariable int id) {
        return emergenciaRepository.deleteEmergencia(id);
    }

}
