/**
 * Author: Oscar Darío Botero Vargas
 * Date:   Lunes 25 de enero de 2021
 * Notes:  Pongo la lógica para el manejo de las empresas...
 */

package co.udea.saetelbackend.Dominio;

import co.udea.saetelbackend.repository.empresas.EmpresaRepository;
import co.udea.saetelbackend.repository.empresas.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Lunes 25 de enero de 2021
 *  @note   Creé esta clase...
 */
@Component
public class DominioEmpresa {
  @Autowired
  private EmpresaRepository repositorioEmpresa;

  public String nombreEmpresa(Integer idEmpresa) throws Exception {
    final Optional<Empresa> empresaRegistrada = repositorioEmpresa.findById(idEmpresa);

    if(empresaRegistrada.isPresent()) {
      final Empresa empresa = empresaRegistrada.get();
      return empresa.getNombre();
    } else {
      throw new Exception("No existe una empresa con id igual a " + idEmpresa + ".");
    }
  }
}
