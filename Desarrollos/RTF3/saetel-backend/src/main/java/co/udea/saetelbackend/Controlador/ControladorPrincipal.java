package co.udea.saetelbackend.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Lunes 25 de enero de 2021
 *  @note   Creé esta clase...
 */
@Controller
public class ControladorPrincipal {

  @Autowired
  private ServletContext contexto;

  @GetMapping(path = {"/v1/principal"})
  public String principal(HttpSession sesión, Model modelo) {
    String nombreVista = contexto.getContextPath() + "/v1/principal";

    try {
      if(sesión.isNew())
        nombreVista = contexto.getContextPath() + "/v1/ingreso";
    } catch(IllegalStateException e) {
      nombreVista = contexto.getContextPath() + "/v1/ingreso";
    }

    return nombreVista;
  }

  @GetMapping(path = {"/v1/ingreso", "/v1/finalice"})
  public String ingreso(HttpSession sesión) {
    sesión.invalidate();
    return contexto.getContextPath() + "/v1/ingreso";
  }
}