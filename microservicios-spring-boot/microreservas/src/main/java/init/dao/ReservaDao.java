package init.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import init.entities.Reserva;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
    // Método para obtener una lista de reservas por usuario
    List<Reserva> findByUsuario(String usuario);
}
