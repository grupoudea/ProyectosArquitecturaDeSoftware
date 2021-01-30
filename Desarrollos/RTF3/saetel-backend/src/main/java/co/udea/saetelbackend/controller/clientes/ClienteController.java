package co.udea.saetelbackend.controller.clientes;

import co.udea.saetelbackend.facade.clientes.ClienteFacade;
import co.udea.saetelbackend.facade.clientes.dto.ClienteDto;
import co.udea.saetelbackend.util.handler.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteFacade clienteFacade;

    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @PostMapping
    @ApiOperation(value = "Crea clientes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ClienteDto>>> crearClientes(@Validated @RequestBody List<ClienteDto> clienteDtos){
        List<ClienteDto> clientesCreados = clienteFacade.crearClientes(clienteDtos);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                clientesCreados));
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el cliente por id", response = ClienteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ClienteDto>> getCliente(@PathVariable(value = "id") Integer id){
        ClienteDto clienteDto = clienteFacade.getCliente(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                clienteDto));
    }

    @GetMapping("/get-todos-by-empresa/{idEmpresa}")
    @ApiOperation(value = "Obtiene todos los clientes de una empresa", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ClienteDto>>> findAll(@PathVariable(value = "idEmpresa") Integer idEmpresa){
        List<ClienteDto> clienteDtoList = clienteFacade.getClientes(idEmpresa);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                clienteDtoList));
    }

}
