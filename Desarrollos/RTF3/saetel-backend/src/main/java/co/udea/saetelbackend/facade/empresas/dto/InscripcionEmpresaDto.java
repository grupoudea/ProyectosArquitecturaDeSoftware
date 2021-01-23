package co.udea.saetelbackend.facade.empresas.dto;

import co.udea.saetelbackend.repository.empresas.entity.Empresa;
import java.time.LocalDate;

public class InscripcionEmpresaDto {

    private Integer id;
    private Integer idEmpresa;
    private Empresa empresa;
    private LocalDate fecha;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
