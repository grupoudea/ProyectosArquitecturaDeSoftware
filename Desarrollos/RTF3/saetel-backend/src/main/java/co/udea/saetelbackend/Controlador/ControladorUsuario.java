package co.udea.saetelbackend.Controlador;

import co.udea.saetelbackend.Dominio.DominioEmpresa;
import co.udea.saetelbackend.Dominio.DominioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Lunes 25 de enero de 2021
 *  @note   Creé esta clase...
 */
@Controller
@RequestMapping(path = {"/v1/usuario", "/v1/usuarios"})
public class ControladorUsuario {

  @Autowired
  private DominioUsuario dominioUsuario;

  /* Lunes 25 de enero de 2021
   *
   * Determino si existe un usuario con las credenciales dadas, o sea, si existe
   * un usuario con el nombre y clave dados.
   *
   * Este método es seguro: No altera los datos almacenados en la base de datos.
   */
  @GetMapping(path = "/credenciales_son_validas")
  public @ResponseBody boolean credencialesSonVálidas(
    @RequestParam                  String      nombre,
    @RequestParam(name = "clave")  String      contraseña,
                                   HttpSession sesión
  ) {
    boolean credencialesSonVálidas = false;

    final DominioUsuario.IdUsuarioVerificado idUsuarioVerificado =
      dominioUsuario.credencialesSonVálidas(nombre, contraseña);

    if(idUsuarioVerificado.credencialesSonVálidas) {
      credencialesSonVálidas  = true;
      sesión.setAttribute("idUsuario", idUsuarioVerificado.idUsuario);
    } else
      sesión.removeAttribute("idUsuario");

    return credencialesSonVálidas;
  }
}
