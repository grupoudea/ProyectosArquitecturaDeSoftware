package co.udea.saetelbackend.repository.usuarios;

import co.udea.saetelbackend.repository.usuarios.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
