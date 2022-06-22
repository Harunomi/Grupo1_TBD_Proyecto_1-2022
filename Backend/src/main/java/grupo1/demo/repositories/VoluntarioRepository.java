package grupo1.demo.repositories;

import grupo1.demo.models.Emergencia;
import grupo1.demo.models.Voluntario;
import grupo1.demo.models.BusquedaVoluntario;
import java.util.*;

public interface VoluntarioRepository {
    public int countVoluntarios();

    public String createVoluntario(Voluntario voluntario);

    public List<Voluntario> getAllVoluntarios();

    public String updateVoluntario(Voluntario voluntario);

    public boolean deleteVoluntario(int id);

    public List<Voluntario> obtenerVoluntariosCercanos(BusquedaVoluntario datos);
}
