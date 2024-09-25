package init.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import init.model.MisReservasDto;
import init.model.ReservaDto;
import init.model.ReservaDtoResumido;
import init.service.ReservaService;

@RestController
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping(value = "altaReserva", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> altaReserva(@RequestBody ReservaDto reservaDto) {
        if (reservaService.altaReserva(reservaDto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    
    @PostMapping(value = "altaReservaResumido", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> altaReservaResumido(@RequestBody ReservaDtoResumido dto) {
        if (reservaService.altaReservaResumido(dto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "porUsuario/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservaDto> obtenerReservasPorUsuario(@PathVariable("usuario") String usuario) {
        return reservaService.obtenerReservasPorUsuario(usuario);
    }
    
    @GetMapping(value = "vistaMisReservas/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MisReservasDto> vistaMisReservas(@PathVariable("usuario") String usuario) {
        return reservaService.vistaMisReservas(usuario);
    }
    
    

}
