package grupo1.demo.repositories;

import grupo1.demo.models.Habilidad;
import java.util.*;
public interface HabilidadRepository {
    public int countHabilidades();

    public String createHabilidad(Habilidad habilidad);

    public List<Habilidad> getAllHabilidades();

    public String updateHabilidad(Habilidad habilidad);

    public boolean deleteHabilidad(int id);
}
