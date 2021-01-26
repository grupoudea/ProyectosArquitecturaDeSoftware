package co.udea.saetelbackend.Controlador;

import co.udea.saetelbackend.Dominio.DominioArchivo;
import co.udea.saetelbackend.Dominio.DominioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Domingo 24 de enero de 2021
 *  @note   Creé esta clase...
 */
@Controller
@RequestMapping(path = "/archivo")
public class ControladorArchivos {

  @Autowired
  private DominioEmpresa dominioEmpresa;

  @Autowired
  private DominioArchivo dominioArchivo;

  // Como no indiqué ruta, entonces esta será la función manejadora por omisión.
  // @GetMapping() equivale a @RequestMapping(method = RequestMethod.GET).
  @GetMapping()
  public String páginaSubaArchivo() {
    return "/v1/pagina_suba_archivo";
  }

  // @PutMapping() equivale a @RequestMapping(method = RequestMethod.PUT).
  @PutMapping(path = "/v1/suba_archivo")
  public String proceseArchivo(
    @RequestParam("tipo_archivo") String cadenaTipoDeArchivo,
    @RequestParam("formato_archivo") String cadenaFormatoDeArchivo,
    @RequestParam("archivo") MultipartFile archivo,
    HttpSession sesión,
    Model modelo
  ) {
    if(archivo.isEmpty()) {
      modelo.addAttribute("archivo_vacio", null);
    } else {
      try {
        Files.createDirectory(DominioArchivo.UBICACIÓN_ALMACENAMIENTO);
      } catch(IOException e) {
        throw new RuntimeException("¡ No pude crear el directorio para el almacenamiento !\nEl directorio que intenté crear fue: \"" + DominioArchivo.UBICACIÓN_ALMACENAMIENTO + "\"");
      }

      try {
        if(sesión.isNew())
          modelo.addAttribute("sesión_no_iniciada", null);
        else {
          if(
            (cadenaTipoDeArchivo == "cliente") ||
            (cadenaTipoDeArchivo == "contrato") ||
            (cadenaTipoDeArchivo == "servicio-contratado")
          ) {
            if(
              (cadenaFormatoDeArchivo == "csv") ||
              (cadenaFormatoDeArchivo == "json")
            ) {
              final Integer idEmpresa = (Integer)(sesión.getAttribute("idEmpresa"));
              //final String nombreEmpresa = DominioEmpresa.nombreEmpresa(idEmpresa);

              StringBuilder cadenaFecha = new StringBuilder(15);

              {
                final Calendar momentoActual = Calendar.getInstance();

                cadenaFecha.append(momentoActual.get(Calendar.YEAR));
                cadenaFecha.append(momentoActual.get(Calendar.MONTH));
                cadenaFecha.append(momentoActual.get(Calendar.DAY_OF_MONTH));
                cadenaFecha.append(momentoActual.get(Calendar.HOUR_OF_DAY));
                cadenaFecha.append(momentoActual.get(Calendar.MINUTE));
                cadenaFecha.append(momentoActual.get(Calendar.SECOND));
              }

              //final String nombreNuevoArchivo = nombreEmpresa + "_" + tipoDeArchivo + "_" + cadenaFecha;
              final String nombreNuevoArchivo = idEmpresa + "_" + cadenaTipoDeArchivo + "_" + cadenaFecha;

              try {
                final Path nombreCompletoNuevoArchivo = DominioArchivo.UBICACIÓN_ALMACENAMIENTO.resolve(nombreNuevoArchivo);

                Files.copy(archivo.getInputStream(), nombreCompletoNuevoArchivo);

                DominioArchivo.TipoArchivo tipoDeArchivo;
                if(cadenaTipoDeArchivo == "cliente")
                  tipoDeArchivo = DominioArchivo.TipoArchivo.CLIENTE;
                else if(cadenaTipoDeArchivo == "contrato")
                  tipoDeArchivo = DominioArchivo.TipoArchivo.CONTRATO;
                else
                  tipoDeArchivo = DominioArchivo.TipoArchivo.SERVICIO_CONTRATADO;

                DominioArchivo.FormatoArchivo formatoArchivo;
                if(cadenaFormatoDeArchivo == "csv")
                  formatoArchivo = DominioArchivo.FormatoArchivo.CSV;
                else
                  formatoArchivo = DominioArchivo.FormatoArchivo.JSON;

                dominioArchivo.proceseArchivo(nombreCompletoNuevoArchivo, tipoDeArchivo, formatoArchivo);
              } catch(Exception e) {
                throw new RuntimeException("¡ Error !\n" + e.getMessage());
              }
            } else
              modelo.addAttribute("formato_desconocido", null);
          } else
            modelo.addAttribute("tipo_desconocido", null);
        }
      } catch(IllegalStateException e) {
        modelo.addAttribute("sesión_inválida", null);
      }
    }

    return String.format("Hello %s!", archivo);
  }
}
