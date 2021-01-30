package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.EstratoRepository;
import co.udea.saetelbackend.repository.clientes.entity.Estrato;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EstratoService {

    private final EstratoRepository repository;

    public EstratoService(EstratoRepository repository) {
        this.repository = repository;
    }

    public List<Estrato> getEstratos(){
        return this.repository.findAll();
    }
}
