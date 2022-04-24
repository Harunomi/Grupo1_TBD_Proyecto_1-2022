package grupo1.demo.repositories;

import grupo1.demo.models.Voluntario_Habilidad;
import java.util.*;


public interface Voluntario_HabilidadRepository {
    public int countVoluntario_Habilidad();

    public String createVoluntario_Habilidad(Voluntario_Habilidad voluntario_Habilidad);

    public List<Emergencia> getAllVoluntario_Habilidad();

    public String updateVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad);

    public boolean deleteVoluntario_Habilidad(int id);
}
