package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.clientes.dto.EstratoDto;
import co.udea.saetelbackend.repository.clientes.entity.Estrato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstratoMapper extends EntityMapper<EstratoDto, Estrato>{
}
