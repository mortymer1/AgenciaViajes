package init.service;

import java.util.List;
import init.model.ReservaDto;

public interface ReservaService {
	
	boolean altaReserva(ReservaDto reservaDto);

    List<ReservaDto> obtenerReservasPorUsuario(String usuario);

	boolean actualizarPlazas(int idVuelo, int numPlazas);

	boolean disponibilidadHotel(int idHotel);

	int disponibilidadPlazasVuelo(int idVuelo);

}
