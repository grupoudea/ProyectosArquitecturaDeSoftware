package co.udea.saetelbackend.facade.clientes;

import co.udea.saetelbackend.facade.clientes.dto.ClienteDto;
import co.udea.saetelbackend.facade.clientes.dto.ContratoDto;
import co.udea.saetelbackend.facade.clientes.dto.CrearClienteDto;
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
public class ClienteFacade {

    private final ClienteMapper mapper;
    private final ClienteService service;
    private final ContratoMapper contratoMapper;
    private final ContratoService contratoService;

    public ClienteFacade(ClienteMapper mapper, ClienteService service, ContratoMapper contratoMapper, ContratoService contratoService) {
        this.mapper = mapper;
        this.service = service;
        this.contratoMapper = contratoMapper;
        this.contratoService = contratoService;
    }

    @Transactional
    public List<ClienteDto> crearClientes(List<CrearClienteDto> crearClienteDtos){
        List<ClienteDto> clientesCreados = new ArrayList<>();
        for (CrearClienteDto crearClienteDto : crearClienteDtos) {
            ClienteDto clienteCreado = mapper.toDto(service.create(mapper.toEntity(crearClienteDto.getCliente())));
            for (ContratoDto contratoDto : crearClienteDto.getContratoDtos()) {
                contratoDto.setIdCliente(clienteCreado.getId());
                contratoService.create(contratoMapper.toEntity(contratoDto));
            }
            clientesCreados.add(clienteCreado);
        }
        return clientesCreados;
    }

}
