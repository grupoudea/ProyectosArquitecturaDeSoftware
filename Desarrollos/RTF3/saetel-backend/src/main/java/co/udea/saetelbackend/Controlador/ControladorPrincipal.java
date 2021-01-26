package co.udea.saetelbackend.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Lunes 25 de enero de 2021
 *  @note   Creé esta clase...
 */
@Controller
public class ControladorPrincipal {

  @GetMapping(path = {"/v1/principal"})
  public String principal(HttpSession sesión, Model modelo) {
    String nombreVista = "v1/principal";;

    try {
      if(sesión.isNew())
        nombreVista = "v1/ingreso";
    } catch(IllegalStateException e) {
      nombreVista = "v1/ingreso";
    }

    return nombreVista;
  }

  @GetMapping(path = {"/v1/ingreso", "/v1/finalice"})
  public String ingreso(HttpSession sesión) {
    sesión.invalidate();
    return "v1/ingreso";
  }
}