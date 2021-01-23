package co.udea.saetelbackend.facade.empresas.dto;

import co.udea.saetelbackend.repository.empresas.entity.Ciudad;
import co.udea.saetelbackend.repository.empresas.entity.Region;

public class CiudadesRegionDto {

    private Integer id;
    private Integer idCiudad;
    private Ciudad ciudad;
    private Integer idRegion;
    private Region region;

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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
