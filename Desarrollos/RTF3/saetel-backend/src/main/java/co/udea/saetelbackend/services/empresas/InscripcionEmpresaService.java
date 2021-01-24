package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.InscripcionEmpresaRepository;
import co.udea.saetelbackend.repository.empresas.entity.InscripcionEmpresa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InscripcionEmpresaService {

    private final InscripcionEmpresaRepository repository;

    public InscripcionEmpresaService(InscripcionEmpresaRepository repository) {
        this.repository = repository;
    }

    public List<InscripcionEmpresa> getEmpresasInscritas(){
        return this.repository.findAll();
    }

}
