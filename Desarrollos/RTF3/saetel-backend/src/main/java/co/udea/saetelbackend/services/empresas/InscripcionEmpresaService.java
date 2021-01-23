package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.InscripcionEmpresaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InscripcionEmpresaService {

    private InscripcionEmpresaRepository repository;

    public InscripcionEmpresaService(InscripcionEmpresaRepository repository) {
        this.repository = repository;
    }

}
