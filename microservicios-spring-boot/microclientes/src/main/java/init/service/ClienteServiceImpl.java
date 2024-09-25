package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.ClienteDao;
import init.model.ClienteDto;
import init.utilidades.Mapeador;

@Service
public class ClienteServiceImpl implements ClienteService {

    ClienteDao clienteDao;
    Mapeador mapeador;

    public ClienteServiceImpl(ClienteDao clienteDao, Mapeador mapeador) {
        super();
        this.clienteDao = clienteDao;
        this.mapeador = mapeador;
    }

    @Override
    public boolean alta(ClienteDto cliente) {
        if (clienteDao.findByUsuario(cliente.getUsuario()).isEmpty()) {
            clienteDao.save(mapeador.clienteDtoToEntity(cliente));
            return true;
        }
        return false;
    }

    @Override
    public ClienteDto buscarClientePorUsuarioYPassword(String usuario, String password) {
    	System.out.println("Usuario: "+usuario);
    	System.out.println("Contrasenya: "+password);
        return clienteDao.findByUsuarioAndPassword(usuario, password)
                .map(c -> mapeador.clienteEntityToDto(c))
                .orElse(null);
    }

    @Override
    public ClienteDto buscarClientePorUsuario(String usuario) {
        return clienteDao.findByUsuario(usuario)
                .map(c -> mapeador.clienteEntityToDto(c))
                .orElse(null);
    }

    @Override
    public List<ClienteDto> recuperarTodos() {
        return clienteDao.findAll().stream()
                .map(c -> mapeador.clienteEntityToDto(c))
                .toList();
    }
}
