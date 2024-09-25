package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import init.model.HotelDto;
import init.service.HotelService;

@RestController
@CrossOrigin(origins = "*")
public class HotelController {
	
    HotelService hotelService;

    public HotelController(HotelService hotelService) {
        super();
        this.hotelService = hotelService;
    }

    @GetMapping(value="buscarhoteles/{localizacion}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<HotelDto> buscarPorLocalizacion(@PathVariable("localizacion") String localizacion) {
        return hotelService.buscarHotelPorLocalizacion(localizacion);
    }

    @GetMapping(value="buscar/{idHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelDto> buscarPorId(@PathVariable("idHotel") int idHotel) {
        HotelDto hotel = hotelService.buscarHotelPorId(idHotel);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }
    
    @GetMapping(value="disponibilidad/{idHotel}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> disponibilidadPorId(@PathVariable("idHotel") int idHotel) {
    boolean disponibilidad = hotelService.disponibilidadPorId(idHotel);
    return new ResponseEntity<Boolean>(disponibilidad ,HttpStatus.OK);
    }

    @GetMapping(value="catalogo", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<HotelDto> buscarTodos() {
        return hotelService.recuperarTodos();
    }
    
    @GetMapping(value="localizaciones", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<String> localizaciones() {
        return hotelService.localizaciones();
    }
}
