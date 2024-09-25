package init.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import init.entities.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByUsuarioAndPassword(String usuario, String password);
    Optional<Cliente> findByUsuario(String usuario);
}
