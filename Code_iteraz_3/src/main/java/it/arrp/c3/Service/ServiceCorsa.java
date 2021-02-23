package it.arrp.c3.Service;

import it.arrp.c3.Model.Corsa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Corsa.
 */
@Service
public class ServiceCorsa {
    @Autowired
    ServicePacco servicePacco;
    @Autowired
    ServiceCorriere serviceCorriere;

    public Corsa creaCorsa(Long uuidCliente, Long uuidCommerciante, Long uuidCorriere, Long uuidBox){
        //TODO da implementare --Ric
        return null;
    }
}
