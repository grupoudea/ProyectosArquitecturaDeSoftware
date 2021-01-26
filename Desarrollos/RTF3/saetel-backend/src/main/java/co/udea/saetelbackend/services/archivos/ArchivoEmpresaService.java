package co.udea.saetelbackend.services.archivos;

import co.udea.saetelbackend.repository.archivos.ArchivoEmpresaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArchivoEmpresaService {

    private ArchivoEmpresaRepository repository;

    public ArchivoEmpresaService(ArchivoEmpresaRepository repository) {
        this.repository = repository;
    }
}
