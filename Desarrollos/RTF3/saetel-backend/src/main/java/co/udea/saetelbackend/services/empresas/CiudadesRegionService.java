package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.CiudadesRegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CiudadesRegionService {

    private CiudadesRegionRepository repository;

    public CiudadesRegionService(CiudadesRegionRepository repository) {
        this.repository = repository;
    }

}
