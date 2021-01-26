package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.EmpresasCiudadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpresasCiudadService {

    private EmpresasCiudadRepository repository;

    public EmpresasCiudadService(EmpresasCiudadRepository repository) {
        this.repository = repository;
    }

}
