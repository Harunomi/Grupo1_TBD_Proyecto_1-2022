package grupo1.demo.repositories;

import grupo1.demo.models.Emergencia_Estado;
import java.util.*;

public interface Emergencia_EstadoRepository {
    public int countEmergenciaEstado();

    public String createEmergenciaEstado(Emergencia_Estado emergencia_Estado);

    public List<Emergencia_Estado> getAllEmergenciaEstado();

    public String updateEmergenciaEstado(Emergencia_Estado emergencia_Estado);

    public boolean deleteEmergenciaEstado(int id);
}
