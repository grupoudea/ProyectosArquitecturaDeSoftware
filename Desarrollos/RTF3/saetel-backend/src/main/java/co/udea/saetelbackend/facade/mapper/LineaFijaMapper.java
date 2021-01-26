package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.servicios.dto.LineaFijaDto;
import co.udea.saetelbackend.repository.servicios.entity.LineaFija;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicioMapper.class})
public interface LineaFijaMapper extends EntityMapper<LineaFijaDto, LineaFija>{
}
