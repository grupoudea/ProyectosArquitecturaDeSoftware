package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.LineaMovilRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LineaMovilService {

    private LineaMovilRepository repository;

    public LineaMovilService(LineaMovilRepository repository) {
        this.repository = repository;
    }
}
