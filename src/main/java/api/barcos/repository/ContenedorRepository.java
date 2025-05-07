package api.barcos.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.barcos.entity.Contenedor;

public interface ContenedorRepository extends JpaRepository<Contenedor, Integer> {
    List<Contenedor> findByBarcoId(Long id);

}



