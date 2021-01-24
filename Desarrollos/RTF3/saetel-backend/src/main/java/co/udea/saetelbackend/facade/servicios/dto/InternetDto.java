package co.udea.saetelbackend.facade.servicios.dto;

public class InternetDto {

    private Integer id;
    private Integer idServicio;
    private ServicioDto servicioDto;
    private Integer velocidad;
    private String tecnologia;

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

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
}
