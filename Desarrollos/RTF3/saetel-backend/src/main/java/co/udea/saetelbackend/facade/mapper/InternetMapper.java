package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.servicios.dto.InternetDto;
import co.udea.saetelbackend.repository.servicios.entity.Internet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicioMapper.class})
public interface InternetMapper extends EntityMapper<InternetDto, Internet>{
}
