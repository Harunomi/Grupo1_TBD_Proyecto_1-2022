package grupo1.demo.repositories;

import java.util.List;

import grupo1.demo.models.Tarea_Habilidad;
public interface Tarea_HabilidadRepository {
    public int countTarea_Habilidad();

    public String createTarea_Habilidad(Tarea_Habilidad tarea_Habilidad);

    public List<Tarea_Habilidad> getAllTarea_Habilidad();

    public String updateTarea_Habilidad(Tarea_Habilidad tarea_Habilidad);

    public boolean deleteTarea_Habilidad(int id);
}
