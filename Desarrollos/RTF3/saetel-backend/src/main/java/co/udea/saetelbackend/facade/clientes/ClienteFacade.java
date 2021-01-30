package co.udea.saetelbackend.facade.clientes;

import co.udea.saetelbackend.facade.clientes.dto.ClienteDto;
import co.udea.saetelbackend.facade.clientes.dto.EstratoDto;
import co.udea.saetelbackend.facade.clientes.dto.TipoDocumentoDto;
import co.udea.saetelbackend.facade.mapper.ClienteMapper;
import co.udea.saetelbackend.facade.mapper.EstratoMapper;
import co.udea.saetelbackend.facade.mapper.TipoDocumentoMapper;
import co.udea.saetelbackend.repository.clientes.entity.Cliente;
import co.udea.saetelbackend.services.clientes.ClienteService;
import co.udea.saetelbackend.services.clientes.EstratoService;
import co.udea.saetelbackend.services.clientes.TipoDocumentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClienteFacade {

    private final ClienteMapper mapper;
    private final ClienteService service;
    private final TipoDocumentoService tipoDocumentoService;
    private final TipoDocumentoMapper tipoDocumentoMapper;
    private final EstratoService estratoService;
    private final EstratoMapper estratoMapper;

    public ClienteFacade(ClienteMapper mapper, ClienteService service,
                         TipoDocumentoService tipoDocumentoService, TipoDocumentoMapper tipoDocumentoMapper,
                         EstratoService estratoService, EstratoMapper estratoMapper) {
        this.mapper = mapper;
        this.service = service;
        this.tipoDocumentoService = tipoDocumentoService;
        this.tipoDocumentoMapper = tipoDocumentoMapper;
        this.estratoService = estratoService;
        this.estratoMapper = estratoMapper;
    }

    @Transactional
    public List<ClienteDto> crearClientes(List<ClienteDto> clienteDtos){
        List<ClienteDto> clientesCreados = new ArrayList<>();
        for (ClienteDto clienteDto : clienteDtos) {
            ClienteDto clienteCreado = mapper.toDto(service.create(mapper.toEntity(clienteDto)));
            clientesCreados.add(clienteCreado);
        }
        return clientesCreados;
    }

    public ClienteDto getCliente(Integer id){
        return mapper.toDto(service.getCliente(id));
    }

    public List<ClienteDto> getClientes(Integer idEmpresa){
        return mapper.toDto(service.getClientes(idEmpresa));
    }

    public List<TipoDocumentoDto> getTiposDocumentos(){
        return tipoDocumentoMapper.toDto(tipoDocumentoService.getTiposDocumentos());
    }

    public List<EstratoDto> getEstratos(){
        return estratoMapper.toDto(estratoService.getEstratos());
    }

}
