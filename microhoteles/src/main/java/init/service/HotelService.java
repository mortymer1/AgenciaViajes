package init.service;

import java.util.List;

import init.model.HotelDto;

public interface HotelService {

	HotelDto buscarHotelPorId(int isbn);
	List<HotelDto> buscarHotelPorLocalizacion(String localizacion);
	List<HotelDto> recuperarTodos();
	boolean disponibilidadPorId(int idHotel);
}
