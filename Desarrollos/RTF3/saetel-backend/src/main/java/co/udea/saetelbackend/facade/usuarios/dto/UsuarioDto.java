package co.udea.saetelbackend.facade.usuarios.dto;

import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;

public class UsuarioDto {

    private Integer id;
    private String correo;
    private String usuario;
    private String clave;
    private String estado;
    private Integer idRol;
    private RolDto rolDto;
    private Integer idEmpresa;
    private EmpresaDto empresaDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public RolDto getRolDto() {
        return rolDto;
    }

    public void setRolDto(RolDto rolDto) {
        this.rolDto = rolDto;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public EmpresaDto getEmpresaDto() {
        return empresaDto;
    }

    public void setEmpresaDto(EmpresaDto empresaDto) {
        this.empresaDto = empresaDto;
    }
}
