package grupo1.demo.repositories;

import grupo1.demo.models.Estado;
import java.util.*;

public interface EstadoRepository {
    public int countEstados();

    public String createEstado(Estado estado);

    public List<Estado> getAllEstados();

    public String updateEstado(Estado estado);

    public boolean deleteEstado(int id);
}
