package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.usuarios.dto.RolDto;
import co.udea.saetelbackend.repository.usuarios.entity.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper extends EntityMapper<RolDto, Rol>{
}
