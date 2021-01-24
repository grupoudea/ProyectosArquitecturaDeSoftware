package co.udea.saetelbackend.controller.empresas;

import co.udea.saetelbackend.facade.empresas.EmpresaFacade;
import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;
import co.udea.saetelbackend.util.handler.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaFacade facade;

    public EmpresaController(EmpresaFacade facade) {
        this.facade = facade;
    }

    @GetMapping()
    @ApiOperation(value = "Lista las empresas", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<EmpresaDto>>> getEmpresas(){
        List<EmpresaDto> empresaDtoList = facade.getEmpresas();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                empresaDtoList));
    }
}
