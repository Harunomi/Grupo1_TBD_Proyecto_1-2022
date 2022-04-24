package grupo1.demo.repositories;

import grupo1.demo.models.Voluntario;
import java.util.*;

public interface VoluntarioRepository {
    public int countVoluntarios();

    public String createVoluntario(Voluntario emergencia);

    public List<Voluntario_Habilidad> getAllVoluntarios();

    public String updateVoluntario(Voluntario emergencia);

    public boolean deleteVoluntario(int id);
}
