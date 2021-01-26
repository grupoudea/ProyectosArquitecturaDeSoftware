package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.ClienteRepository;
import co.udea.saetelbackend.repository.clientes.entity.Cliente;
import co.udea.saetelbackend.util.exception.DataConstraintViolationException;
import co.udea.saetelbackend.util.exception.DataDuplicatedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente create(Cliente cliente){
        if(Objects.nonNull(cliente.getId())){
            Optional<Cliente> clienteOptional = repository.findById(cliente.getId());
            if(clienteOptional.isPresent()){
                throw new DataDuplicatedException("Cliente duplicado");
            }
        }
        try {
            return repository.save(cliente);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("Cliente duplicado");
        }
    }

}
