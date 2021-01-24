package co.udea.saetelbackend.facade.servicios.dto;

import co.udea.saetelbackend.facade.clientes.dto.ContratoDto;

import java.time.LocalDate;

public class ServicioContratoDto {

    private Integer id;
    private Integer idContrato;
    private ContratoDto contrato;
    private Integer idServicio;
    private ServicioDto servicio;
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

    public ContratoDto getContrato() {
        return contrato;
    }

    public void setContrato(ContratoDto contrato) {
        this.contrato = contrato;
    }

    public ServicioDto getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDto servicio) {
        this.servicio = servicio;
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
