package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.EstratoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstratoService {

    private EstratoRepository repository;

    public EstratoService(EstratoRepository repository) {
        this.repository = repository;
    }

}
