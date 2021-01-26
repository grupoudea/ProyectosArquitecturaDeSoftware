package co.udea.saetelbackend.facade.empresas;

import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;
import co.udea.saetelbackend.facade.empresas.dto.InscripcionEmpresaDto;
import co.udea.saetelbackend.facade.mapper.InscripcionEmpresaMapper;
import co.udea.saetelbackend.services.empresas.InscripcionEmpresaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InscripcionEmpresaFacade {

    private final InscripcionEmpresaMapper mapper;
    private final InscripcionEmpresaService service;
    private final EmpresaFacade empresaFacade;

    public InscripcionEmpresaFacade(InscripcionEmpresaMapper mapper, InscripcionEmpresaService service, EmpresaFacade empresaFacade) {
        this.mapper = mapper;
        this.service = service;
        this.empresaFacade = empresaFacade;
    }

    public List<InscripcionEmpresaDto> getEmpresasInscritas(){
        return this.mapper.toDto(this.service.getEmpresasInscritas());
    }

    public List<EmpresaDto> getEmpresasNoInscritas(){
        List<EmpresaDto> empresas = this.empresaFacade.getEmpresas();
        List<InscripcionEmpresaDto> empresasInscritas = this.getEmpresasInscritas();
        List<EmpresaDto> empresasNoInscritas = new ArrayList<>();

        for (EmpresaDto empresa : empresas) {
            InscripcionEmpresaDto inscrita = empresasInscritas.stream()
                    .filter(item -> empresa.getId().equals(item.getIdEmpresa()))
                    .findAny()
                    .orElse(null);
            if(inscrita == null){
                empresasNoInscritas.add(empresa);
            }
        }
        return empresasNoInscritas;
    }

}
