package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.empresas.dto.InscripcionEmpresaDto;
import co.udea.saetelbackend.repository.empresas.entity.InscripcionEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class})
public interface InscripcionEmpresaMapper extends EntityMapper<InscripcionEmpresaDto, InscripcionEmpresa>{
}
