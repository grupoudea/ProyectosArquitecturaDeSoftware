package co.udea.saetelbackend.services.archivos;

import co.udea.saetelbackend.repository.archivos.PeriodoCargaArchivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeriodoCargaArchivoService {

    private PeriodoCargaArchivoRepository repository;

    public PeriodoCargaArchivoService(PeriodoCargaArchivoRepository repository) {
        this.repository = repository;
    }
}
