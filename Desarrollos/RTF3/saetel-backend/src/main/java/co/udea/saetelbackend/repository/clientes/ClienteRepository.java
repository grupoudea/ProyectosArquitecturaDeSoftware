package co.udea.saetelbackend.repository.clientes;

import co.udea.saetelbackend.repository.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c. = :numeroDocumento AND c.tipoDocumento = :tipoDocumento")
    Cliente getClienteByDocumento(@Param("idEmpresa") Integer idEmpresa);

    @Query("SELECT c FROM Cliente c JOIN p.proveedor_fk pd WHERE (p.nombre LIKE %:texto% OR p.descripcion LIKE %:texto% OR pd.nombre_empresa LIKE %:texto%)")
    List<Cliente> getClientesByEmpresa(@Param("texto") String texto);
}
