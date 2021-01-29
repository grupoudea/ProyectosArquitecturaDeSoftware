package co.udea.saetelbackend.facade.clientes.dto;

import java.util.List;

public class CrearClienteDto {
    private ClienteDto cliente;
    private List<ContratoDto> contratoDtos;

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public List<ContratoDto> getContratoDtos() {
        return contratoDtos;
    }

    public void setContratoDtos(List<ContratoDto> contratoDtos) {
        this.contratoDtos = contratoDtos;
    }
}
