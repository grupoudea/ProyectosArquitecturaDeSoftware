package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.empresas.dto.RegionDto;
import co.udea.saetelbackend.repository.empresas.entity.Region;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegionMapper extends EntityMapper<RegionDto, Region>{
}
