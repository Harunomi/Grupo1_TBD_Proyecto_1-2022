package grupo1.demo.repositories;

import grupo1.demo.models.Emergencia_Habilidad;
import java.util.*;

public interface Emergencia_HabilidadRepository {
    public int countEmergencia_Habilidad();

    public String createEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad);

    public List<Emergencia_Habilidad> getAllEmergencia_Habilidad();

    public String updateEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad);

    public boolean deleteEmergencia_Habilidad(int id);
}
