package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.clientes.dto.TipoDocumentoDto;
import co.udea.saetelbackend.repository.clientes.entity.TipoDocumento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper extends EntityMapper<TipoDocumentoDto, TipoDocumento>{
}
