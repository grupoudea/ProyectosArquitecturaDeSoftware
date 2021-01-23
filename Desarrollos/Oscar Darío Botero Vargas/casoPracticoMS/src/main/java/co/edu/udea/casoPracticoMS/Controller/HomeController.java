/* Author: Oscar Darío Botero Vargas
 * Date:   Sábado 23 de enero de 2021
 * Notes:
 */

package co.edu.udea.casoPracticoMS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

  @GetMapping(value = "/")
  public String principal() {
    return "Hola desde el mundo Spring Boot";
  }

  @GetMapping(value = "/hello")
  public String saludo() { return "¡ Saludos desde el mundo Spring Boot !"; }
}
