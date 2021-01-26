package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.empresas.dto.CiudadDto;
import co.udea.saetelbackend.repository.empresas.entity.Ciudad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CiudadMapper extends EntityMapper<CiudadDto, Ciudad>{
}
