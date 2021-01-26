package co.udea.saetelbackend.facade.archivo.dto;

import java.time.LocalDate;

public class PeriodoCargaArchivoDto {

    private Integer id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
