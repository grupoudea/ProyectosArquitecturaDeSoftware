package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.CiudadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CiudadService {

    private CiudadRepository repository;

    public CiudadService(CiudadRepository repository) {
        this.repository = repository;
    }
}
