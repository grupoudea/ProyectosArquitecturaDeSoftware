package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.LineaFijaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LineaFijaService {

    private LineaFijaRepository repository;

    public LineaFijaService(LineaFijaRepository repository) {
        this.repository = repository;
    }
}
