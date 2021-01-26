package co.udea.saetelbackend.facade.clientes;

import co.udea.saetelbackend.facade.clientes.dto.ClienteDto;
import co.udea.saetelbackend.facade.mapper.ClienteMapper;
import co.udea.saetelbackend.services.clientes.ClienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteFacade {

    private final ClienteMapper mapper;
    private final ClienteService service;

    public ClienteFacade(ClienteMapper mapper, ClienteService service) {
        this.mapper = mapper;
        this.service = service;
    }
    

}
