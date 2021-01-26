package co.udea.saetelbackend.services.archivos;

import co.udea.saetelbackend.repository.archivos.PlantillaArchivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlantillaArchivoService {

    private PlantillaArchivoRepository repository;

    public PlantillaArchivoService(PlantillaArchivoRepository repository) {
        this.repository = repository;
    }
}
