package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.ClienteDto;
import init.service.ClienteService;

@RestController
public class ClienteController {

    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        super();
        this.clienteService = clienteService;
    }

    @GetMapping(value = "login/{usuario}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDto> login(@PathVariable("usuario") String usuario,
                                                                       @PathVariable("password") String password) {
        ClienteDto cliente = clienteService.buscarClientePorUsuarioYPassword(usuario, password);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "alta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> altaCliente(@RequestBody ClienteDto cliente) {
        if (clienteService.alta(cliente)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


    @GetMapping(value = "buscarcliente/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDto> buscarClientePorUsuario(@PathVariable("usuario") String usuario) {
        ClienteDto cliente = clienteService.buscarClientePorUsuario(usuario);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @GetMapping(value = "clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteDto> recuperarTodos() {
        return clienteService.recuperarTodos();
    }
}
