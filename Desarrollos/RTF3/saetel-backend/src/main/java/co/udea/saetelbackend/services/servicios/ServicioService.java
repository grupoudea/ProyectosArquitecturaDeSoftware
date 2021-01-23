package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.ServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioService {

    private ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }
}
