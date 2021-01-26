package co.udea.saetelbackend.facade.empresas.dto;


public class CiudadesRegionDto {

    private Integer id;
    private Integer idCiudad;
    private CiudadDto ciudad;
    private Integer idRegion;
    private RegionDto region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public CiudadDto getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDto ciudad) {
        this.ciudad = ciudad;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }
}
