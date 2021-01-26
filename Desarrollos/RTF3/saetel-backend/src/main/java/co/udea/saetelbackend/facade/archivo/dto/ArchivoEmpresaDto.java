package co.udea.saetelbackend.facade.archivo.dto;

import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;

import java.time.LocalDate;

public class ArchivoEmpresaDto {

    private Integer id;
    private Integer idEmpresa;
    private EmpresaDto empresaDto;
    private LocalDate fechaCarga;
    private String enlace;
    private String estado;

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

    public EmpresaDto getEmpresaDto() {
        return empresaDto;
    }

    public void setEmpresaDto(EmpresaDto empresaDto) {
        this.empresaDto = empresaDto;
    }

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDate fechaCarga) {
        this.fechaCarga = fechaCarga;
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
}
