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

import grupo1.demo.models.Emergencia_Habilidad;
import grupo1.demo.repositories.Emergencia_HabilidadRepository;

@RestController
@CrossOrigin(origins = "*")
public class Emergencia_HabilidadService {
    private final Emergencia_HabilidadRepository emergencia_habilidadRepository;

    Emergencia_HabilidadService(Emergencia_HabilidadRepository emergencia_habilidadRepository){
        this.emergencia_habilidadRepository = emergencia_habilidadRepository;
    }

    @GetMapping("/emergencia_habilidad/count")
    public String countEmergencia_Habilidad(){
        int total = emergencia_habilidadRepository.countEmergencia_Habilidad();
        return String.format("existen %s Emergencia_Habilidades ",total);
    }

    // Create
    @PostMapping("/emergencia_habilidad/create")
    @ResponseBody
    public String createEmergencia_Habilidad(@RequestBody Emergencia_Habilidad Emergencia_habilidad){
        return emergencia_habilidadRepository.createEmergencia_Habilidad(Emergencia_habilidad);
    }

    // read all
    @GetMapping("/emergencia_habilidades")
    public List<Emergencia_Habilidad> getAllEmergencia_Habilidad(){
        return emergencia_habilidadRepository.getAllEmergencia_Habilidad();
    }

    // update
    @PostMapping("/emergencia_habilidad/updateEmergencia_Habilidad")
    @ResponseBody
    public String updateEmergencia_Habilidad(@RequestBody Emergencia_Habilidad emergencia_habilidad){
        return emergencia_habilidadRepository.updateEmergencia_Habilidad(emergencia_habilidad);
    }

    // delete
    @DeleteMapping("/emergencia_habilidad/delete/{id}")
    @ResponseBody
    public boolean deleteEmergencia_Habilidad(@PathVariable int id){
        return emergencia_habilidadRepository.deleteEmergencia_Habilidad(id);
    }
}
