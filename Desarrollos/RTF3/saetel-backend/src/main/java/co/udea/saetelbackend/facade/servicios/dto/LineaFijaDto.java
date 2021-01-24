package co.udea.saetelbackend.facade.servicios.dto;

public class LineaFijaDto {

    private Integer id;
    private Integer idServicio;
    private ServicioDto servicioDto;
    private String alcance;

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

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }
}
