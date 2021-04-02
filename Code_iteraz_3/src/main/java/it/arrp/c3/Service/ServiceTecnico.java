package it.arrp.c3.Service;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Repository.TecnicoRepository;
import it.arrp.c3.Model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Tecnico.
 */
@Service
public class ServiceTecnico {
    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    TecnicoRepository repoTecnico;

    public String getChiaveTecnico(UUID uuidTecnico){
        //TODO da implementare --Ric
        return null;
    }

    public boolean creaTecnico(Long idCliente, Admin admin) {
        Cliente c = serviceCliente.getCliente(idCliente);
        repoTecnico.save(new Tecnico(idCliente,admin));
        c.aggiungiRuolo("Tecnico");
        //TODO da cambiare, non penso vada bene che il serviceTecnico modifichi cose
        // di un cliente anche se é lui stesso. --Ric

        //TODO da implementare un controllo per verificare che sia andato tutto in porto. --Ric
        return true;
    }
}
