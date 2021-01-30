package co.udea.saetelbackend.repository.usuarios;

import co.udea.saetelbackend.repository.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  /* Lunes 25 de enero de 2021
   *
   * Encuentra y retorna todos los usuarios que tienen el nombre dado.
   */
  List<Usuario> findByUsuario(String nombre);
}
