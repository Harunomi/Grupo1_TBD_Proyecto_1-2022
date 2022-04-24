package grupo1.demo.repositories;

import grupo1.demo.models.Emergencia;
import java.util.*;
public interface EmergenciaRepository {
    public int countEmergencias();

    public String createEmergencia(Emergencia emergencia);

    public List<Emergencia> getAllEmergencias();

    public String updateEmergencia(Emergencia emergencia);

    public boolean deleteEmergencia(int id);
}
