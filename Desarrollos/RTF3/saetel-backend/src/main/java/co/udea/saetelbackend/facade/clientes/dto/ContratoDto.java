package co.udea.saetelbackend.facade.clientes.dto;

import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;
import java.time.LocalDate;

public class ContratoDto {

    private Integer id;
    private String numeroContrato;
    private Integer idEmpresa;
    private EmpresaDto empresaDto;
    private Integer idCliente;
    private ClienteDto clienteDto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String direccion;
    private Integer idEstrato;
    private EstratoDto estratoDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdEstrato() {
        return idEstrato;
    }

    public void setIdEstrato(Integer idEstrato) {
        this.idEstrato = idEstrato;
    }

    public EstratoDto getEstratoDto() {
        return estratoDto;
    }

    public void setEstratoDto(EstratoDto estratoDto) {
        this.estratoDto = estratoDto;
    }
}
