package init.utilidades;

import org.springframework.stereotype.Component;
import init.entities.Reserva;
import init.model.ReservaDto;
import init.model.ReservaDtoResumido;

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

	public Reserva reservaDtoResumidoToEntity(ReservaDtoResumido dto) {
		Reserva reserva = new Reserva();
		reserva.setHotel(dto.getHotel());
		reserva.setUsuario(dto.getUsuario());
		reserva.setPlazas(dto.getPlazas());
		reserva.setVuelo(dto.getVuelo());
		
		return reserva;
	}
}
