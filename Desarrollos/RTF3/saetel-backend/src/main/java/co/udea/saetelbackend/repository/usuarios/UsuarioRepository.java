package co.udea.saetelbackend.repository.usuarios;

import co.udea.saetelbackend.repository.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
