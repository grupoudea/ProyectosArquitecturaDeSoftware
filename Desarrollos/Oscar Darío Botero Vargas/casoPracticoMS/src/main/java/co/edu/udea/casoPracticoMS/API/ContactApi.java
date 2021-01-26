/* Author: Oscar Darío Botero Vargas
 * Date:   Sábado 23 de enero de 2021
 * Notes:
 */

package co.edu.udea.casoPracticoMS.API;

import co.edu.udea.casoPracticoMS.DTO.ContactoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class ContactApi {

  @GetMapping(path = "/contact")
  public String principal() {
    return new ContactoDTO(
      38L,
      "Oscar Darío",
      "Botero Vargas",
      "+57 300 399 37 53",
      "oscar.botero@udea.edu.co"
    ).toString();
  }

  @GetMapping(path = "/contacto")
  public ContactoDTO contacto() {
    return new ContactoDTO(
      38L,
      "Oscar Darío",
      "Botero Vargas",
      "+57 300 399 37 53",
      "oscar.botero@udea.edu.co"
    );
  }
}
