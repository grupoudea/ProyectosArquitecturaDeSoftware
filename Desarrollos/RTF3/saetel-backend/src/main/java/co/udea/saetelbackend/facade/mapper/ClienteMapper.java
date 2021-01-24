package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.clientes.dto.ClienteDto;
import co.udea.saetelbackend.repository.clientes.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TipoDocumentoMapper.class,})
public interface ClienteMapper extends EntityMapper<ClienteDto, Cliente>{
}
