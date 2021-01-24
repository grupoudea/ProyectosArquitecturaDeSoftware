package co.udea.saetelbackend.facade.servicios.dto;

public class TelevisionDto {

    private Integer id;
    private Integer idServicio;
    private ServicioDto servicioDto;
    private Integer cantidadCanales;
    private String calidad;
    private Integer cantidadDecodificadores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public ServicioDto getServicioDto() {
        return servicioDto;
    }

    public void setServicioDto(ServicioDto servicioDto) {
        this.servicioDto = servicioDto;
    }

    public Integer getCantidadCanales() {
        return cantidadCanales;
    }

    public void setCantidadCanales(Integer cantidadCanales) {
        this.cantidadCanales = cantidadCanales;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public Integer getCantidadDecodificadores() {
        return cantidadDecodificadores;
    }

    public void setCantidadDecodificadores(Integer cantidadDecodificadores) {
        this.cantidadDecodificadores = cantidadDecodificadores;
    }
}
