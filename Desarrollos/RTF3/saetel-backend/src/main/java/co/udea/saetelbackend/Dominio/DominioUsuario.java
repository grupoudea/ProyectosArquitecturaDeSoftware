/**
 * Author: Oscar Darío Botero Vargas
 * Date:   Lunes 25 de enero de 2021
 * Notes:  Pongo la lógica para el manejo de los usuarios...
 */

package co.udea.saetelbackend.Dominio;

import co.udea.saetelbackend.repository.usuarios.UsuarioRepository;
import co.udea.saetelbackend.repository.usuarios.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @log
 *  @author Oscar Darío Botero Vargas
 *  @date   Lunes 25 de enero de 2021
 *  @note   Creé esta clase...
 */
@Component
public class DominioUsuario {
  @Autowired
  private UsuarioRepository repositorioUsuario;

  public static class IdUsuarioVerificado {
    public boolean credencialesSonVálidas = false;
    public int idUsuario = 0;
  }

  /* Lunes 25 de enero de 2021
   *
   * Determino si existe un usuario con las credenciales dadas, o sea, si existe
   * un usuario con el nombre y clave dados.
   */
  public IdUsuarioVerificado credencialesSonVálidas(
    String nombre,
    String contraseña
  ) {
    final IdUsuarioVerificado valorRetorno = new IdUsuarioVerificado();
    valorRetorno.credencialesSonVálidas = false;

    final List<Usuario> usuarios = repositorioUsuario.findByUsuario(nombre);

    for(final Usuario usuario : usuarios) {
      if (usuario.getClave().equals(contraseña)) {
        valorRetorno.credencialesSonVálidas = true;
        valorRetorno.idUsuario = usuario.getId();
        break;
      }
    }

    return valorRetorno;
  }
}
