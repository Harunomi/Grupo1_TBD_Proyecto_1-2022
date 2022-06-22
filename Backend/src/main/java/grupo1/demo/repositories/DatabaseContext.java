package grupo1.demo.repositories;

import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class DatabaseContext {
    // Definir url de la DB, usuario y pass
    // ej: jdbc:postgresql://127.0.0.1:5432/postgres, usuario y pass
    @Bean
    public Sql2o sql2o() {
        return new Sql2o("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "grupo1");
    }
}
