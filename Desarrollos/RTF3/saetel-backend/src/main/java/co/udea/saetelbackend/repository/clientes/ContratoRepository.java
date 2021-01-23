package co.udea.saetelbackend.repository.clientes;

import co.udea.saetelbackend.repository.clientes.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
