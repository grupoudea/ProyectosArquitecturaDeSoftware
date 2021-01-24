package co.udea.saetelbackend.facade.servicios.dto;

public class LineaMovilDto {

    private Integer id;
    private Integer idServicio;
    private ServicioDto servicio;
    private String tipoPlan;
    private String datosMegas;
    private String mensajesTextos;
    private String minutos;

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

    public ServicioDto getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDto servicio) {
        this.servicio = servicio;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getDatosMegas() {
        return datosMegas;
    }

    public void setDatosMegas(String datosMegas) {
        this.datosMegas = datosMegas;
    }

    public String getMensajesTextos() {
        return mensajesTextos;
    }

    public void setMensajesTextos(String mensajesTextos) {
        this.mensajesTextos = mensajesTextos;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }
}
