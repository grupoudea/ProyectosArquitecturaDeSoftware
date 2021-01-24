package co.udea.saetelbackend.facade.servicios.dto;

import co.udea.saetelbackend.facade.clientes.dto.ContratoDto;

import java.time.LocalDate;

public class ServicioContratoDto {

    private Integer id;
    private Integer idContrato;
    private ContratoDto contratoDto;
    private Integer idServicio;
    private ServicioDto servicioDto;
    private Double precio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public ContratoDto getContratoDto() {
        return contratoDto;
    }

    public void setContratoDto(ContratoDto contratoDto) {
        this.contratoDto = contratoDto;
    }

    public ServicioDto getServicioDto() {
        return servicioDto;
    }

    public void setServicioDto(ServicioDto servicioDto) {
        this.servicioDto = servicioDto;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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
