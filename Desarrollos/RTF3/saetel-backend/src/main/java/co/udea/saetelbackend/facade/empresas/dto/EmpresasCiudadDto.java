package co.udea.saetelbackend.facade.empresas.dto;

public class EmpresasCiudadDto {

    private Integer id;
    private Integer idEmpresa;
    private EmpresaDto empresa;
    private Integer idCiudad;
    private CiudadDto ciudad;
    private String direccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }

    public CiudadDto getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDto ciudad) {
        this.ciudad = ciudad;
    }
}
