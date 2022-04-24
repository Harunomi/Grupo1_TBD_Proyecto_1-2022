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

import grupo1.demo.models.Voluntario_Habilidad;
import grupo1.demo.repositories.Voluntario_HabilidadRepository;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class Voluntario_HabilidadService {
    private final Voluntario_HabilidadRepository voluntario_habilidadRepository;

    Voluntario_HabilidadService(Voluntario_HabilidadRepository voluntario_habilidadRepository){
        this.voluntario_habilidadRepository = voluntario_habilidadRepository;
    }

    @GetMapping("/voluntario_habilidad/count")
    public String countVoluntario_Habilidad(){
        int total = voluntario_habilidadRepository.countVoluntario_Habilidad();
        return String.format("existen %s voluntario_habilidades",total);
    }

    // Create
    @PostMapping("/voluntario_habilidad/create")
    @ResponseBody
    public String createVoluntario_Habilidad(@RequestBody Voluntario_Habilidad voluntario_habilidad){
        return voluntario_habilidadRepository.createVoluntario_Habilidad(voluntario_habilidad);
    }

    // read all
    @GetMapping("/voluntario_habilidades")
    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad(){
        return voluntario_habilidadRepository.getAllVoluntario_Habilidad();
    }

    // update
    @PostMapping("/voluntario_habilidades/updateVoluntario_Habilidad")
    @ResponseBody
    public String updateVoluntario_Habilidad(@RequestBody Voluntario_Habilidad voluntario_habilidad){
        return voluntario_habilidadRepository.updateVoluntario_Habilidad(voluntario_habilidad);
    }

    // delete
    @DeleteMapping("/voluntario_habilidad/delete/{id}")
    @ResponseBody
    public boolean deleteVoluntario_Habilidad(@PathVariable int id){
        return voluntario_habilidadRepository.deleteVoluntario_Habilidad(id);
    }

}
