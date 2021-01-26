package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.archivo.dto.ArchivoEmpresaDto;
import co.udea.saetelbackend.repository.archivos.entity.ArchivoEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class})
public interface ArchivoEmpresaMapper extends EntityMapper<ArchivoEmpresaDto, ArchivoEmpresa>{
}
