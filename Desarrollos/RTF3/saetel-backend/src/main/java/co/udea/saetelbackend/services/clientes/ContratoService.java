package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.ContratoRepository;
import co.udea.saetelbackend.repository.clientes.entity.Contrato;
import co.udea.saetelbackend.util.exception.DataDuplicatedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ContratoService {

    private ContratoRepository repository;

    public ContratoService(ContratoRepository repository) {
        this.repository = repository;
    }

    public Contrato create(Contrato contrato){
        if(Objects.nonNull(contrato.getId())){
            Optional<Contrato> contratoOptional = repository.findById(contrato.getId());
            if(contratoOptional.isPresent()){
                throw new DataDuplicatedException("Contrato duplicado");
            }
        }
        return repository.save(contrato);
    }
}
