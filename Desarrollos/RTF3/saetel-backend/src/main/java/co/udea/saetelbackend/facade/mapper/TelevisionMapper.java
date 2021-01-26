package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.servicios.dto.TelevisionDto;
import co.udea.saetelbackend.repository.servicios.entity.Television;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicioMapper.class})
public interface TelevisionMapper extends EntityMapper<TelevisionDto, Television>{
}
