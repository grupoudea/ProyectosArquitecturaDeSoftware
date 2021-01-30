package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.TipoDocumentoRepository;
import co.udea.saetelbackend.repository.clientes.entity.TipoDocumento;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoDocumentoService {

    private final TipoDocumentoRepository repository;

    public TipoDocumentoService(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    public List<TipoDocumento> getTiposDocumentos(){
        return this.repository.findAll();
    }
}
