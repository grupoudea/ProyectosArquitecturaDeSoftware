package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.archivo.dto.PlantillaArchivoDto;
import co.udea.saetelbackend.repository.archivos.entity.PlantillaArchivo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantillaArchivoMapper extends EntityMapper<PlantillaArchivoDto, PlantillaArchivo>{
}
