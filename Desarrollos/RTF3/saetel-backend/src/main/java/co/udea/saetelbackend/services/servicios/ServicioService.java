package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.ServicioRepository;
import co.udea.saetelbackend.repository.servicios.entity.Servicio;
import co.udea.saetelbackend.util.exception.DataDuplicatedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ServicioService {

    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    public Servicio create(Servicio servicio){
        if(Objects.nonNull(servicio.getId())){
            Optional<Servicio> servicioOptional = repository.findById(servicio.getId());
            if(servicioOptional.isPresent()){
                throw new DataDuplicatedException("Servicio duplicado");
            }
        }
        return repository.save(servicio);
    }
}
