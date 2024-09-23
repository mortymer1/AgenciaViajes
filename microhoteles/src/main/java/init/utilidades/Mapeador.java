package init.utilidades;

import org.springframework.stereotype.Component;

import init.entities.Hotel;
import init.model.HotelDto;

@Component
public class Mapeador {

    public HotelDto hotelEntityToDto(Hotel hotel) {
        return new HotelDto(
            hotel.getIdHotel(),
            hotel.getNombre(),
            hotel.getPrecio(),
            hotel.getCategoria(),
            hotel.getDisponible(),
            hotel.getLocalizacion()
        );
    }

    public Hotel hotelDtoToEntity(HotelDto hotelDto) {
        return new Hotel(
            hotelDto.getIdHotel(),
            hotelDto.getNombre(),
            hotelDto.getPrecio(),
            hotelDto.getCategoria(),
            hotelDto.getDisponible(),
            hotelDto.getLocalizacion()
        );
    }
}
