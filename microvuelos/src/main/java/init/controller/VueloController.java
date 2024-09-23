package init.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import init.model.VueloDto;
import init.service.VueloService;

@RestController
public class VueloController {

    VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping(value = "buscarVuelos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VueloDto> buscarVuelos(@RequestParam String destino, @RequestParam int plazas) {
        return vueloService.buscarVuelosPorDestinoYPlazas(destino, plazas);
    }

    @PutMapping(value = "actualizarPlazas/{idVuelo}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizarPlazas(@PathVariable("idVuelo") int idVuelo, @RequestBody Map<String, Integer> requestBody) {
        int plazasReservadas = requestBody.get("plazasReservadas");

        if (vueloService.actualizarPlazas(idVuelo, plazasReservadas)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "buscarVuelo/{idVuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VueloDto> buscarVueloPorId(@PathVariable("idVuelo") int idVuelo) {
        VueloDto vuelo = vueloService.buscarVueloPorId(idVuelo);
        if (vuelo != null) {
            return new ResponseEntity<>(vuelo, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value = "disponibilidadPlazas/{idVuelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> plazasPorId(@PathVariable("idVuelo") int idVuelo) {
        int plazas = vueloService.plazasPorId(idVuelo);
        return new ResponseEntity<>(plazas, HttpStatus.OK);
    }
}
