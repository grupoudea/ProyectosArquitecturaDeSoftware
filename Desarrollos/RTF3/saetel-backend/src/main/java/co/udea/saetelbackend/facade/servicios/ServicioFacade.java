package co.udea.saetelbackend.facade.servicios;

import co.udea.saetelbackend.facade.mapper.ServicioMapper;
import co.udea.saetelbackend.facade.servicios.dto.ServicioDto;
import co.udea.saetelbackend.services.servicios.ServicioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioFacade {

    private final ServicioMapper mapper;
    private final ServicioService service;

    public ServicioFacade(ServicioMapper mapper, ServicioService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @Transactional
    public List<ServicioDto> crearServicios(List<ServicioDto> servicioDtos){
        List<ServicioDto> serviciosCreados = new ArrayList<>();
        for (ServicioDto servicioDto : servicioDtos) {
            ServicioDto servicioCreado = mapper.toDto(service.create(mapper.toEntity(servicioDto)));
            serviciosCreados.add(servicioCreado);
        }
        return serviciosCreados;
    }

}
