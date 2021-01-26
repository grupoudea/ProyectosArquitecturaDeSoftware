package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.servicios.dto.ServicioDto;
import co.udea.saetelbackend.repository.servicios.entity.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicioMapper extends EntityMapper<ServicioDto, Servicio>{
}
