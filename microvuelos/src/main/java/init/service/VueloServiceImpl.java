package init.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import init.dao.VueloDao;
import init.entities.Vuelo;
import init.model.VueloDto;
import init.utilidades.Mapeador;

@Service
public class VueloServiceImpl implements VueloService {

    VueloDao vueloDao;
    Mapeador mapeador;

    public VueloServiceImpl(VueloDao vueloDao, Mapeador mapeador) {
        this.vueloDao = vueloDao;
        this.mapeador = mapeador;
    }

    @Override
    public List<VueloDto> buscarVuelosPorDestinoYPlazas(String destino, int plazas) {
        return vueloDao.findByDestinoAndPlazasGreaterThanEqual(destino, plazas)
                .stream()
                .map(mapeador::vueloEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean actualizarPlazas(int idVuelo, int plazasReservadas) {
        Optional<Vuelo> vueloOpt = vueloDao.findById(idVuelo);
        if (vueloOpt.isPresent()) {
            Vuelo vuelo = vueloOpt.get();
            int nuevasPlazas = vuelo.getPlazas() - plazasReservadas;
            if (nuevasPlazas >= 0) {
                vuelo.setPlazas(nuevasPlazas);
                vueloDao.save(vuelo);
                return true;
            }
        }
        return false;
    }

    @Override
    public VueloDto buscarVueloPorId(int idVuelo) {
        return vueloDao.findById(idVuelo)
                .map(mapeador::vueloEntityToDto)
                .orElse(null);
    }
    
	@Override
	public int plazasPorId(int idVuelo) {
		VueloDto vuelo;
	    vuelo = vueloDao.findById(idVuelo)
	            .map(v -> mapeador.vueloEntityToDto(v))
	            .orElse(null);
	    return vuelo.getPlazas();
	}
}
