package co.udea.saetelbackend.facade.empresas;

import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;
import co.udea.saetelbackend.facade.mapper.EmpresaMapper;
import co.udea.saetelbackend.services.empresas.EmpresaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpresaFacade {

    private final EmpresaMapper mapper;
    private final EmpresaService service;

    public EmpresaFacade(EmpresaMapper mapper, EmpresaService service) {
        this.mapper = mapper;
        this.service = service;
    }

    public List<EmpresaDto> getEmpresas(){
        return this.mapper.toDto(this.service.getEmpresas());
    }

}
