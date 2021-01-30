package co.udea.saetelbackend.repository.clientes;

import co.udea.saetelbackend.repository.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
