package it.arrp.c3.Service;

import it.arrp.c3.Model.Pacco;
import it.arrp.c3.Model.Repository.PaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Pacco.
 */
@Service
public class ServicePacco {

    @Autowired
    PaccoRepository paccoRepo;

    public Pacco creaPacco(long idCliente, long idCommerciante){
        return new Pacco(idCommerciante,idCliente);
    }

    public Pacco getPacco(Long id){
        return paccoRepo.findOneByIdPacco(id);
    }

    //TODO facciamo un CRUD anche quí come in serviceProdotto? o magari senza la modifica? o lasciamo cosí? --Ric
}
