package init.service;

import java.util.List;

import init.model.ClienteDto;

public interface ClienteService {

	boolean alta(ClienteDto cliente);
	ClienteDto buscarClientePorUsuarioYPassword(String usuario, String password);
	ClienteDto buscarClientePorUsuario(String usuario);
	List<ClienteDto> recuperarTodos();
}
