package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.ServicioContratoRepository;
import co.udea.saetelbackend.repository.servicios.entity.ServicioContrato;
import co.udea.saetelbackend.util.exception.DataDuplicatedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ServicioContratoService {

    private final ServicioContratoRepository repository;

    public ServicioContratoService(ServicioContratoRepository repository) {
        this.repository = repository;
    }

    public ServicioContrato create(ServicioContrato servicioContrato){
        if(Objects.nonNull(servicioContrato.getId())){
            Optional<ServicioContrato> servicioContratoOptional = repository.findById(servicioContrato.getId());
            if(servicioContratoOptional.isPresent()){
                throw new DataDuplicatedException("Servicio Contrato duplicado");
            }
        }
        return repository.save(servicioContrato);
    }
}
