package init.service;

import java.util.List;
import init.model.VueloDto;

public interface VueloService {
    // Lista de vuelos por destino y número de plazas disponibles
    List<VueloDto> buscarVuelosPorDestinoYPlazas(String destino, int plazas);
    
    // Actualización de plazas de un vuelo
    boolean actualizarPlazas(int idVuelo, int plazasReservadas);

    // Obtener datos de un vuelo por identificador
    VueloDto buscarVueloPorId(int idVuelo);

	int plazasPorId(int idVuelo);
}
