package co.udea.saetelbackend.facade.servicios;

import co.udea.saetelbackend.facade.mapper.ServicioContratoMapper;
import co.udea.saetelbackend.services.servicios.ServicioContratoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioContratoFacade {

    private final ServicioContratoMapper mapper;
    private final ServicioContratoService service;

    public ServicioContratoFacade(ServicioContratoMapper mapper, ServicioContratoService service) {
        this.mapper = mapper;
        this.service = service;
    }

}
