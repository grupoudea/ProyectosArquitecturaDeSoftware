package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;
import co.udea.saetelbackend.repository.empresas.entity.Empresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper extends EntityMapper<EmpresaDto, Empresa>{
}
