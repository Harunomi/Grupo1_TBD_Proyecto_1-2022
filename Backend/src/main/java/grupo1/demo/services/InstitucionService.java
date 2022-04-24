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

import grupo1.demo.models.Institucion;
import grupo1.demo.repositories.InstitucionRepository;

@RestController
@CrossOrigin(origins = "*")
public class InstitucionService {

    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/instituciones/count")
    public String countInstituciones() {
        int total = institucionRepository.countInstituciones();
        return String.format("Tienes %s Instituciones!", total);
    }

    // Create
    @PostMapping("/instituciones/create")
    @ResponseBody
    public String createInstitucion(@RequestBody Institucion institucion) {
        return institucionRepository.createInstitucion(institucion);
    }

    // Read all
    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones() {
        return institucionRepository.getAllInstituciones();
    }

    // uUPODATE
    @PostMapping("/instituciones/updateInstitucion")
    @ResponseBody
    public String updateInstitucion(@RequestBody Institucion institucion) {
        return institucionRepository.updateInstitucion(institucion);
    }

    // Delete
    @DeleteMapping("/instituciones/delete/{id}")
    @ResponseBody
    public boolean deleteInstitucion(@PathVariable int id) {
        return institucionRepository.deleteInstitucion(id);
    }

}
