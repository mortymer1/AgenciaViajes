package init.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import init.entities.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {
	
	List<Hotel> findByLocalizacion(String localizacion);

}
