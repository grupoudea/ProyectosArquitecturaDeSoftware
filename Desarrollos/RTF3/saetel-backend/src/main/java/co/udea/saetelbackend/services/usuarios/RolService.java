package co.udea.saetelbackend.services.usuarios;

import co.udea.saetelbackend.repository.usuarios.RolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {

    private RolRepository repository;

    public RolService(RolRepository repository) {
        this.repository = repository;
    }
}
