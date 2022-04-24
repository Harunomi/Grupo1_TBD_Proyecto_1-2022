package grupo1.demo.repositories;

import java.util.List;

import grupo1.demo.models.Tarea;

public interface TareaRepository {
    public int countTareas();

    public String createTarea(Tarea tarea);

    public List<Tarea> getAllTareas();

    public String updateTarea(Tarea tarea);

    public boolean deleteTarea(int id);
}
