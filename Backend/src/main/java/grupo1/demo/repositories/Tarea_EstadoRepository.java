package grupo1.demo.repositories;

import java.util.List;

import grupo1.demo.models.Tarea_Estado;

public interface Tarea_EstadoRepository {
    public int countTarea_Estado();

    public String createTarea_Estado(Tarea_Estado tarea_Estado);

    public List<Tarea_Estado> getAllTarea_Estado();

    public String updateTarea_Estado(Tarea_Estado tarea_Estado);

    public boolean deleteTarea_Estado(int id);
}
