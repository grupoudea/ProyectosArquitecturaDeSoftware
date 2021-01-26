package co.udea.saetelbackend.services.servicios;

import co.udea.saetelbackend.repository.servicios.InternetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InternetService {

    private InternetRepository repository;

    public InternetService(InternetRepository repository) {
        this.repository = repository;
    }
}
