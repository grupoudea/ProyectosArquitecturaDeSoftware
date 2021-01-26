package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TelevisionService {

    private TelevisionRepository repository;

    public TelevisionService(TelevisionRepository repository) {
        this.repository = repository;
    }
}
