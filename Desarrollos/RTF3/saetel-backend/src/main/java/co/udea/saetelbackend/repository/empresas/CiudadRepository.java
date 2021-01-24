package co.udea.saetelbackend.repository.empresas;

import co.udea.saetelbackend.repository.empresas.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}
