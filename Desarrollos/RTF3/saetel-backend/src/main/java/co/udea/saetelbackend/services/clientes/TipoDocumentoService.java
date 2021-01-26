package co.udea.saetelbackend.services.clientes;

import co.udea.saetelbackend.repository.clientes.TipoDocumentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoDocumentoService {

    private TipoDocumentoRepository repository;

    public TipoDocumentoService(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

}
