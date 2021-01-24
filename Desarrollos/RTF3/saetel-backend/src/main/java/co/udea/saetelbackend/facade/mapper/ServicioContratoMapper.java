package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.servicios.dto.ServicioContratoDto;
import co.udea.saetelbackend.repository.servicios.entity.ServicioContrato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicioMapper.class, ContratoMapper.class})
public interface ServicioContratoMapper extends EntityMapper<ServicioContratoDto, ServicioContrato>{
}
