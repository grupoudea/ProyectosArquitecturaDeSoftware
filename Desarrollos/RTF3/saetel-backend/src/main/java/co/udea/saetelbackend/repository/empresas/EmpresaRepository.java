package co.udea.saetelbackend.repository.empresas;

import co.udea.saetelbackend.repository.empresas.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
