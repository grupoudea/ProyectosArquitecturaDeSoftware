package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.empresas.dto.CiudadesRegionDto;
import co.udea.saetelbackend.repository.empresas.entity.CiudadesRegion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class, CiudadMapper.class})
public interface CiudadesRegionMapper extends EntityMapper<CiudadesRegionDto, CiudadesRegion>{
}
