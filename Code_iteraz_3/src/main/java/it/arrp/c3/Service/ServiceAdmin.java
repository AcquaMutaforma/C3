package it.arrp.c3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Admin.
 */
@Service
public class ServiceAdmin {
    @Autowired
    ServiceLocker serviceLocker;

    public  boolean creaRichiesta (Long idTecnico, String testoRichiesta){
        //TODO da implementare --Ric
        return true;
    }
    public boolean creaLocker(int latitudine, int longitudine, int dimensioniLocker){
        serviceLocker.generaLocker(latitudine,longitudine,dimensioniLocker);
        return true;
    }

}
