package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.servicios.dto.LineaMovilDto;
import co.udea.saetelbackend.repository.servicios.entity.LineaMovil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicioMapper.class})
public interface LineaMovilMapper extends EntityMapper<LineaMovilDto, LineaMovil>{
}
