package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.usuarios.dto.UsuarioDto;
import co.udea.saetelbackend.repository.usuarios.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario>{
}
