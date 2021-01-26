package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.ServicioContratoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioContratoService {

    private ServicioContratoRepository repository;

    public ServicioContratoService(ServicioContratoRepository repository) {
        this.repository = repository;
    }
}
