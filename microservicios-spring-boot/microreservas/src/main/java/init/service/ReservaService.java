package init.service;

import java.util.List;
import init.model.ReservaDto;
import init.model.ReservaDtoResumido;

public interface ReservaService {
	
	boolean altaReserva(ReservaDto reservaDto);

    List<ReservaDto> obtenerReservasPorUsuario(String usuario);

	boolean actualizarPlazas(int idVuelo, int numPlazas);

	boolean disponibilidadHotel(int idHotel);

	int disponibilidadPlazasVuelo(int idVuelo);

	boolean altaReservaResumido(ReservaDtoResumido reservaDto);

}
