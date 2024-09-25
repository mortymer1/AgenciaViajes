package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.HotelDao;
import init.model.HotelDto;
import init.utilidades.Mapeador;
@Service
public class HotelServiceImpl implements HotelService {
	
	HotelDao hotelDao;
	Mapeador mapeador;
	

	public HotelServiceImpl(HotelDao hotelDao, Mapeador mapeador) {
		super();
		this.hotelDao = hotelDao;
		this.mapeador = mapeador;
	}

	@Override
	public List<HotelDto> buscarHotelPorLocalizacion(String localizacion) {
		return hotelDao.findByLocalizacion(localizacion)
				.stream()
				.map(h->mapeador.hotelEntityToDto(h))
				.toList();
	}

	@Override
	public HotelDto buscarHotelPorId(int idHotel) {
	    return hotelDao.findById(idHotel)
	            .map(h -> mapeador.hotelEntityToDto(h))
	            .orElse(null); 
	}
	
	@Override
	public boolean disponibilidadPorId(int idHotel) {
		HotelDto hotel;
	    hotel = hotelDao.findById(idHotel)
	            .map(h -> mapeador.hotelEntityToDto(h))
	            .orElse(null);
	    if(hotel.getDisponible()==1) {
	    	return true;
	    }else {
	    	return false;
	    }
	    
	}

	@Override
	public List<HotelDto> recuperarTodos() {
	    return hotelDao.findAll()
	            .stream()
	            .map(h -> mapeador.hotelEntityToDto(h))
	            .toList();
	}

	@Override
	public List<String> localizaciones() {
	    return hotelDao.findAll()
	            .stream()
	            .map(h -> h.getLocalizacion().toLowerCase()) // Convierte todas las localizaciones a minúsculas
	            .distinct() // Elimina duplicados, ignorando mayúsculas y minúsculas
	            .toList();
	}


	

}
