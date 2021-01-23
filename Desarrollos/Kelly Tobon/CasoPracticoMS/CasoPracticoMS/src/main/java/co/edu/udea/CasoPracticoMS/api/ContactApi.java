package co.edu.udea.CasoPracticoMS.api;

import co.edu.udea.CasoPracticoMS.dto.Contacto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class ContactApi {

    @GetMapping(value = "/contact")
    public Contacto getContacto(){
        return new Contacto(1038814926L, "Kelly", "Tobón", "+57 3207742404",
                "kelly.tobon@udea.edu.co");
    }

}
