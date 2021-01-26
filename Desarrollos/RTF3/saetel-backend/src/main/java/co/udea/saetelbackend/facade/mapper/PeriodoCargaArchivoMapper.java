package co.udea.saetelbackend.facade.mapper;

import co.udea.saetelbackend.facade.archivo.dto.PeriodoCargaArchivoDto;
import co.udea.saetelbackend.repository.archivos.entity.PeriodoCargaArchivo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeriodoCargaArchivoMapper extends EntityMapper<PeriodoCargaArchivoDto, PeriodoCargaArchivo>{
}
