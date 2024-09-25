package init.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import init.dao.ReservaDao;
import init.model.ReservaDto;
import init.model.ReservaDtoResumido;
import init.utilidades.Mapeador;

@Service
public class ReservaServiceImpl implements ReservaService {

	ReservaDao reservaDao;
	Mapeador mapeador;
	RestClient restClient;

	public ReservaServiceImpl(ReservaDao reservaDao, Mapeador mapeadorReserva, RestClient restClient) {
		this.reservaDao = reservaDao;
		this.mapeador = mapeadorReserva;
		this.restClient = restClient;
	}

	@Override
	public boolean altaReserva(ReservaDto reservaDto) {
		
		System.out.println(reservaDto);
		
		boolean disponibilidadHotel = disponibilidadHotel(reservaDto.getHotel());
		boolean disponibilidadPlazasVuelo = disponibilidadPlazasVuelo(reservaDto.getVuelo())>reservaDto.getPlazas();
		if (disponibilidadHotel && disponibilidadPlazasVuelo){
			reservaDao.save(mapeador.reservaDtoToEntity(reservaDto));
			return true;
		}else {
			System.out.println("disponibilidadHotel: "+disponibilidadHotel);
			System.out.println("disponibilidadPlazasVuelo: "+disponibilidadPlazasVuelo);
			return false;
		}
	}
	
	@Override
	public boolean altaReservaResumido(ReservaDtoResumido dto) {
		
		System.out.println(dto);
		
		boolean disponibilidadHotel = disponibilidadHotel(dto.getHotel());
		boolean disponibilidadPlazasVuelo = disponibilidadPlazasVuelo(dto.getVuelo())>dto.getPlazas();
		if (disponibilidadHotel && disponibilidadPlazasVuelo){
			reservaDao.save(mapeador.reservaDtoResumidoToEntity(dto));
			return true;
		}else {
			System.out.println("disponibilidadHotel: "+disponibilidadHotel);
			System.out.println("disponibilidadPlazasVuelo: "+disponibilidadPlazasVuelo);
			return false;
		}
	}

	@Override
	public boolean actualizarPlazas(int idVuelo, int numPlazas) {
		String url = "http://localhost:10003/vuelos/actualizarPlazas/" + idVuelo;

		try {
			restClient.put().uri(url).header("Content-Type", "application/json")
					.body("{\"plazasReservadas\": " + numPlazas + "}").retrieve();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<ReservaDto> obtenerReservasPorUsuario(String usuario) {
		return reservaDao.findByUsuario(usuario).stream().map(mapeador::reservaEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public boolean disponibilidadHotel(int idHotel) {
		String url = "http://localhost:10001/hoteles/disponibilidad/" + idHotel;

		try {
			return restClient.get()
			.uri(url)
			.accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(Boolean.class);

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public int disponibilidadPlazasVuelo(int idVuelo) {
		String url = "http://localhost:10003/vuelos/disponibilidadPlazas/" + idVuelo;
		try {
			return restClient.get()
					.uri(url)
					.accept(MediaType.APPLICATION_JSON)
		            .retrieve()
		            .body(Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}
	
}
