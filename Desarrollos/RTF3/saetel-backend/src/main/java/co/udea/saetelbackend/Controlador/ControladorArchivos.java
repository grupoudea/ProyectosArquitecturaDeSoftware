package co.udea.saetelbackend.Controlador;

import co.udea.saetelbackend.Dominio.DominioArchivo;
import co.udea.saetelbackend.Dominio.DominioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Optional;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Domingo 24 de enero de 2021
 *  @note   Creé esta clase...
 */
@Controller
@RequestMapping(path = "/v1/archivo")
public class ControladorArchivos {

  @Autowired
  private DominioEmpresa dominioEmpresa;

  @Autowired
  private DominioArchivo dominioArchivo;

  private enum CódigoError {
    ARCHIVO_VACIO,
    SESIÓN_NO_INICIADA,
    NO_PUDE_PROCESAR_EL_ARCHIVO,
    FORMATO_DESCONOCIDO,
    TIPO_DESCONOCIDO,
    SESIÓN_INVÁLIDA,
    FALTA_ALGÚN_PARÁMETRO
  }

  // @PostMapping() equivale a @RequestMapping(method = RequestMethod.POST).
  @PostMapping(path = "suba_archivo", produces = "application/json")
  @ResponseBody
  public String proceseArchivo(
    @RequestParam("tipoDeArchivo")     Optional<String>        cadenaTipoDeArchivoOpcional,
    @RequestParam("formatoDeArchivo")  Optional<String>        cadenaFormatoDeArchivoOpcional,
    @RequestParam("archivoParaEnviar") Optional<MultipartFile> archivoOpcional,
    HttpSession sesión
  ) {
    final StringBuilder retorno = new StringBuilder();

    if(
      cadenaTipoDeArchivoOpcional.isPresent() &&
      cadenaFormatoDeArchivoOpcional.isPresent() &&
      archivoOpcional.isPresent()
    ) {
      final String        cadenaTipoDeArchivo    = cadenaTipoDeArchivoOpcional.get().trim();
      final String        cadenaFormatoDeArchivo = cadenaFormatoDeArchivoOpcional.get().trim();
      final MultipartFile archivo                = archivoOpcional.get();

      if(archivo.isEmpty())
        retorno.append("{\"error\":" + CódigoError.ARCHIVO_VACIO.ordinal() + "}");
      else {
        try {
          if (!Files.exists(DominioArchivo.UBICACIÓN_ALMACENAMIENTO)) {
            try {
              Files.createDirectory(DominioArchivo.UBICACIÓN_ALMACENAMIENTO);
            } catch (java.nio.file.FileAlreadyExistsException e) {
              throw new RuntimeException("¡ No pude crear el directorio para el almacenamiento pues ya existe uno con ese nombre !\nEl directorio que intenté crear fue: \"" + DominioArchivo.UBICACIÓN_ALMACENAMIENTO + "\"");
            } catch (SecurityException e) {
              throw new RuntimeException("¡ Debido a las restricciones por seguridad no pude crear el directorio para el almacenamiento !\nEl directorio que intenté crear fue: \"" + DominioArchivo.UBICACIÓN_ALMACENAMIENTO + "\"");
            } catch (IOException e) {
              throw new RuntimeException("¡ No pude crear el directorio para el almacenamiento !\nEl directorio que intenté crear fue: \"" + DominioArchivo.UBICACIÓN_ALMACENAMIENTO + "\"");
            }
          }
        } catch(SecurityException e) {
          throw new RuntimeException("¡ Debido a las restricciones por seguridad no pude determinar si el directorio existe !\nEl directorio por que que pregunté fue:\"" + DominioArchivo.UBICACIÓN_ALMACENAMIENTO + "\"");
        }

        try {
          if(sesión.isNew())
            retorno.append("{\"error\":" + CódigoError.SESIÓN_NO_INICIADA.ordinal() + "}");
          else {
            if(
              cadenaTipoDeArchivo.equals(DominioArchivo.TipoDeArchivo.CLIENTE.toString())  ||
              cadenaTipoDeArchivo.equals(DominioArchivo.TipoDeArchivo.CONTRATO.toString()) ||
              cadenaTipoDeArchivo.equals(DominioArchivo.TipoDeArchivo.SERVICIO_CONTRATADO.toString())
            ) {
              if(
                cadenaFormatoDeArchivo.equals(DominioArchivo.FormatoDeArchivo.CSV.toString()) ||
                cadenaFormatoDeArchivo.equals(DominioArchivo.FormatoDeArchivo.JSON.toString())
              ) {
                DominioArchivo.TipoDeArchivo tipoDeArchivo = tipoDeArchivo = DominioArchivo.TipoDeArchivo.CLIENTE;

                if(cadenaTipoDeArchivo.equals(DominioArchivo.TipoDeArchivo.CLIENTE.toString()))
                  tipoDeArchivo = DominioArchivo.TipoDeArchivo.CLIENTE;
                else if(cadenaTipoDeArchivo.equals(DominioArchivo.TipoDeArchivo.CONTRATO.toString()))
                  tipoDeArchivo = DominioArchivo.TipoDeArchivo.CONTRATO;
                else if(cadenaTipoDeArchivo.equals(DominioArchivo.TipoDeArchivo.SERVICIO_CONTRATADO.toString()))
                  tipoDeArchivo = DominioArchivo.TipoDeArchivo.SERVICIO_CONTRATADO;

                final Integer idEmpresa = (Integer)(sesión.getAttribute("idEmpresa"));
                //final String nombreEmpresa = DominioEmpresa.nombreEmpresa(idEmpresa);

                final StringBuilder cadenaFecha = new StringBuilder(15);

                {
                  final Calendar momentoActual = Calendar.getInstance();

                  cadenaFecha.append(momentoActual.get(Calendar.YEAR));
                  cadenaFecha.append(momentoActual.get(Calendar.MONTH));
                  cadenaFecha.append(momentoActual.get(Calendar.DAY_OF_MONTH));
                  cadenaFecha.append(momentoActual.get(Calendar.HOUR_OF_DAY));
                  cadenaFecha.append(momentoActual.get(Calendar.MINUTE));
                  cadenaFecha.append(momentoActual.get(Calendar.SECOND));
                }

                final StringBuilder nombreTipoDeArchivo = new StringBuilder();
                switch(tipoDeArchivo) {
                  case CLIENTE:             nombreTipoDeArchivo.append("cliente");             break;
                  case CONTRATO:            nombreTipoDeArchivo.append("contrato");            break;
                  case SERVICIO_CONTRATADO: nombreTipoDeArchivo.append("servicio-contratado"); break;
                }

                //final String nombreNuevoArchivo = nombreEmpresa + "_" + tipoDeArchivo + "_" + cadenaFecha;
                final String nombreNuevoArchivo = idEmpresa + "_" + nombreTipoDeArchivo + "_" + cadenaFecha;

                try {
                  final Path nombreCompletoNuevoArchivo = DominioArchivo.UBICACIÓN_ALMACENAMIENTO.resolve(nombreNuevoArchivo);

                  Files.copy(archivo.getInputStream(), nombreCompletoNuevoArchivo);

                  DominioArchivo.FormatoDeArchivo formatoArchivo = formatoArchivo = DominioArchivo.FormatoDeArchivo.CSV;
                  if(cadenaFormatoDeArchivo.equals(DominioArchivo.FormatoDeArchivo.CSV.toString()))
                    formatoArchivo = DominioArchivo.FormatoDeArchivo.CSV;
                  else
                    formatoArchivo = DominioArchivo.FormatoDeArchivo.JSON;

                  if(
                    dominioArchivo.proceseArchivo(
                      nombreCompletoNuevoArchivo,
                      tipoDeArchivo,
                      formatoArchivo
                    ) == DominioArchivo.ResultadoDelProcesamiento.ÉXITO
                  )
                    retorno.append("{\"éxito\": \"archivo importado\"}");
                  else
                    retorno.append("{\"error\":" + CódigoError.NO_PUDE_PROCESAR_EL_ARCHIVO.ordinal() + "}");
                } catch(Exception e) {
                  throw new RuntimeException("¡ Error !\n" + e.getMessage());
                }
              } else
                retorno.append("{\"error\":" + CódigoError.FORMATO_DESCONOCIDO.ordinal() + "}");
            } else
              retorno.append("{\"error\":" + CódigoError.TIPO_DESCONOCIDO.ordinal() + "}");
          }
        } catch(IllegalStateException e) {
          retorno.append("{\"error\":" + CódigoError.SESIÓN_INVÁLIDA.ordinal() + "}");
        }
      }
    } else
      retorno.append("{\"error\":" + CódigoError.FALTA_ALGÚN_PARÁMETRO.ordinal() + '}');

    return retorno.toString();
  }
}
