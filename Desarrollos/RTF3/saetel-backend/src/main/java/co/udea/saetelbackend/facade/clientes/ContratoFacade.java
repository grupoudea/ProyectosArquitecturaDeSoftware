package co.udea.saetelbackend.facade.clientes;

import co.udea.saetelbackend.facade.clientes.dto.ClienteDto;
import co.udea.saetelbackend.facade.clientes.dto.ContratoDto;
import co.udea.saetelbackend.facade.mapper.ClienteMapper;
import co.udea.saetelbackend.facade.mapper.ContratoMapper;
import co.udea.saetelbackend.services.clientes.ClienteService;
import co.udea.saetelbackend.services.clientes.ContratoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContratoFacade {

    private final ContratoMapper mapper;
    private final ContratoService service;
    private final ClienteFacade clienteFacade;

    public ContratoFacade(ContratoMapper mapper, ContratoService service, ClienteFacade clienteFacade) {
        this.mapper = mapper;
        this.service = service;
        this.clienteFacade = clienteFacade;
    }

    @Transactional
    public List<ContratoDto> crearContratos(List<ContratoDto> contratoDtos){
        List<ContratoDto> contratosCreados = new ArrayList<>();
        for (ContratoDto contratoDto : contratoDtos) {
            ClienteDto clienteBuscar =  clienteFacade.getCliente(contratoDto.getCliente().getId());
            contratoDto.setIdCliente(clienteBuscar.getId());
            ContratoDto contratoCreado = mapper.toDto(service.create(mapper.toEntity(contratoDto)));
            contratosCreados.add(contratoCreado);
        }
        return contratosCreados;
    }

}
