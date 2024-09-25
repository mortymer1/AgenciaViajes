package init.utilidades;

import org.springframework.stereotype.Component;
import init.entities.Vuelo;
import init.model.VueloDto;

@Component
public class Mapeador {

    // Método para convertir de Entidad Vuelo a DTO VueloDto
    public VueloDto vueloEntityToDto(Vuelo vuelo) {
        return new VueloDto(
            vuelo.getIdvuelo(),
            vuelo.getCompany(),
            vuelo.getFecha(),
            vuelo.getPrecio(),
            vuelo.getPlazas(),
            vuelo.getDestino()
        );
    }

    // Método para convertir de DTO VueloDto a Entidad Vuelo
    public Vuelo vueloDtoToEntity(VueloDto vueloDto) {
        return new Vuelo(
            vueloDto.getIdvuelo(),
            vueloDto.getCompany(),
            vueloDto.getFecha(),
            vueloDto.getPrecio(),
            vueloDto.getPlazas(),
            vueloDto.getDestino()
        );
    }
}
