package co.udea.saetelbackend.services.empresas;

import co.udea.saetelbackend.repository.empresas.EmpresaRepository;
import co.udea.saetelbackend.repository.empresas.entity.Empresa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> getEmpresas(){
        return this.repository.findAll();
    }

}
