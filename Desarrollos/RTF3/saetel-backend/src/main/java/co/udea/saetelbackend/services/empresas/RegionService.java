package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegionService {

    private RegionRepository repository;

    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }
}
