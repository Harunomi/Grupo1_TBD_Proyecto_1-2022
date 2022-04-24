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

import grupo1.demo.models.Estado;
import grupo1.demo.repositories.EstadoRepository;


@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class EstadoService {
    private final EstadoRepository estadoRepository;

    EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    
    @GetMapping("/estados/count")
    public String countEstados() {
        int total = estadoRepository.countEstados();
        return String.format("existen %s estados", total);
    }

    // Create
    @PostMapping("/estados/create")
    @ResponseBody
    public String createEstado(@RequestBody Estado estado) {
        return estadoRepository.createEstado(estado);
    }
    
    // Read all
    @GetMapping("/estados")
    public List<Estado> getAllEstados() {
        return estadoRepository.getAllEstados();
    }

    // uUPODATE
    @PostMapping("/estados/updateEstado")
    @ResponseBody
    public String updateEstado(@RequestBody Estado estado) {
        return estadoRepository.updateEstado(estado);
    }
    // Delete
    @DeleteMapping("/estados/delete/{id}")
    @ResponseBody
    public boolean deleteEstado(@PathVariable int id) {
        return estadoRepository.deleteEstado(id);
    }
}
