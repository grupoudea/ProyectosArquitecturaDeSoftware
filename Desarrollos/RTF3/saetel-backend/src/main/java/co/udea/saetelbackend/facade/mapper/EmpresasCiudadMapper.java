package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.empresas.dto.EmpresasCiudadDto;
import co.udea.saetelbackend.repository.empresas.entity.EmpresasCiudad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",  uses = {CiudadMapper.class,})
public interface EmpresasCiudadMapper extends EntityMapper<EmpresasCiudadDto, EmpresasCiudad>{
}
