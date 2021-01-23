package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.ContratoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContratoService {

    private ContratoRepository repository;

    public ContratoService(ContratoRepository repository) {
        this.repository = repository;
    }

}
