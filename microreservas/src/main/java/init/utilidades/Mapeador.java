package init.utilidades;

import org.springframework.stereotype.Component;
import init.entities.Reserva;
import init.model.ReservaDto;

@Component
public class Mapeador {

    public ReservaDto reservaEntityToDto(Reserva reserva) {
        return new ReservaDto(
            reserva.getIdreserva(),
            reserva.getUsuario(),
            reserva.getHotel(),
            reserva.getVuelo(),
            reserva.getPrecio(),
            reserva.getPlazas()
        );
    }

    public Reserva reservaDtoToEntity(ReservaDto reservaDto) {
        return new Reserva(
            reservaDto.getIdreserva(),
            reservaDto.getUsuario(),
            reservaDto.getHotel(),
            reservaDto.getVuelo(),
            reservaDto.getPrecio(),
            reservaDto.getPlazas()
        );
    }
}
