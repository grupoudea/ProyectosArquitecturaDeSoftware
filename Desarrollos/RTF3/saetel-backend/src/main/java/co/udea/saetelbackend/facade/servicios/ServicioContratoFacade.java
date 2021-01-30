package co.udea.saetelbackend.facade.servicios;

import co.udea.saetelbackend.facade.mapper.ServicioContratoMapper;
import co.udea.saetelbackend.facade.servicios.dto.ServicioContratoDto;
import co.udea.saetelbackend.services.servicios.ServicioContratoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioContratoFacade {

    private final ServicioContratoMapper mapper;
    private final ServicioContratoService service;

    public ServicioContratoFacade(ServicioContratoMapper mapper, ServicioContratoService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @Transactional
    public List<ServicioContratoDto> crearServiciosContratos(List<ServicioContratoDto> servicioContratoDtos){
        List<ServicioContratoDto> serviciosContratosCreados = new ArrayList<>();
        for (ServicioContratoDto servicioContratoDto : servicioContratoDtos) {
            ClienteDto clienteBuscar =  clienteFacade.getClienteByDocumento(contratoDto.getCliente().getNumeroDocumento(), contratoDto.getCliente().getTipoDocumento().getId());
            contratoDto.setIdCliente(clienteBuscar.getId());
            ContratoDto contratoCreado = mapper.toDto(service.create(mapper.toEntity(contratoDto)));
            contratosCreados.add(contratoCreado);
        }
        return contratosCreados;
    }

}
