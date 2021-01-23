package co.edu.udea.api;

import co.edu.udea.dto.ContactoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class ContactApi {
    @GetMapping(value = "/contact")
    public ContactoDto getContacto(){
        return new ContactoDto(10L,"Juan Guillermo", "Hernandez Alarcon",
                "3235841683", "guillermo.hernandez1@udea.edu.co");
    }
}
