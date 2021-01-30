/**
 * Author: Oscar Darío Botero Vargas
 * Date:   Lunes 25 de enero de 2021
 * Notes:  Pongo la lógica para el manejo de los archivos...
 */

package co.udea.saetelbackend.Dominio;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Lunes 25 de enero de 2021
 *  @note   Creé esta clase...
 */
@Component
public class DominioArchivo {
  public static final Path UBICACIÓN_ALMACENAMIENTO = Paths.get("almacenamiento").toAbsolutePath();

  public enum TipoDeArchivo {
    CLIENTE,
    CONTRATO,
    SERVICIO_CONTRATADO
  }

  public enum FormatoDeArchivo {
    CSV,
    JSON
  }

  public enum ResultadoDelProcesamiento {
    ÉXITO,
    ERROR
  }

  public ResultadoDelProcesamiento proceseArchivo(
    Path nombreCompletoNuevoArchivo,
    TipoDeArchivo tipoDeArchivo,
    FormatoDeArchivo formatoArchivo
  ) {
    return ResultadoDelProcesamiento.ÉXITO;
  }
}
