package co.udea.saetelbackend.facade.archivo.dto;

public class PlantillaArchivoDto {

    private Integer id;
    private String enlace;
    private String estado;
    private Integer pesoMaximoMegas;
    private String tipoArchivo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPesoMaximoMegas() {
        return pesoMaximoMegas;
    }

    public void setPesoMaximoMegas(Integer pesoMaximoMegas) {
        this.pesoMaximoMegas = pesoMaximoMegas;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }
}
