package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.clientes.dto.ContratoDto;
import co.udea.saetelbackend.repository.clientes.entity.Contrato;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EstratoMapper.class, ClienteMapper.class, EmpresaMapper.class})
public interface ContratoMapper extends EntityMapper<ContratoDto, Contrato>{
}
