package co.udea.saetelbackend.controller.empresas;

import co.udea.saetelbackend.facade.empresas.InscripcionEmpresaFacade;
import co.udea.saetelbackend.facade.empresas.dto.EmpresaDto;
import co.udea.saetelbackend.facade.empresas.dto.InscripcionEmpresaDto;
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
@RequestMapping("/inscripcion-empresa")
public class InscripcionEmpresaController {

    private final InscripcionEmpresaFacade facade;

    public InscripcionEmpresaController(InscripcionEmpresaFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/get-inscritas")
    @ApiOperation(value = "Lista las empresas inscritas", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<InscripcionEmpresaDto>>> getEmpresasInscritas(){
        List<InscripcionEmpresaDto> inscripcionEmpresaDtoList = facade.getEmpresasInscritas();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                inscripcionEmpresaDtoList));
    }

    @GetMapping("/get-no-inscritas")
    @ApiOperation(value = "Lista las empresas no inscritas", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<EmpresaDto>>> getEmpresasNoInscritas(){
        List<EmpresaDto> empresaDtoList = facade.getEmpresasNoInscritas();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                empresaDtoList));
    }
}
