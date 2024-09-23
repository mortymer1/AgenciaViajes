package init.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import init.entities.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo, Integer> {
    // Método para encontrar vuelos por destino y número de plazas disponibles
    List<Vuelo> findByDestinoAndPlazasGreaterThanEqual(String destino, int plazas);

    // Otros métodos pueden ser añadidos según sea necesario
}
