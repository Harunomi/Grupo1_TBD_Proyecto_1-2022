package grupo1.demo.repositories;

import grupo1.demo.models.Institucion;
import java.util.*;

public interface InstitucionRepository {

    public int countInstituciones();

    public String createInstitucion(Institucion institucion);

    public List<Institucion> getAllInstituciones();

    public String updateInstitucion(Institucion institucion);

    public boolean deleteInstitucion(int id);

}
