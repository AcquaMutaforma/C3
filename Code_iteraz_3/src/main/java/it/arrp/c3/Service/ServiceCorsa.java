package it.arrp.c3.Service;

import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Pacco;

import java.util.UUID;

public class ServiceCorsa {
    //TODO impostare le variabili in modo differente, forse con un autowiring?
    ServicePacco servicePacco= new ServicePacco();
    ServiceCorriere serviceCorriere = new ServiceCorriere();

    public boolean creaCorsa(UUID uuidCliente, UUID uuidCommerciante, UUID uuidCorriere, UUID uuidBox){
        //TODO da implementare --Ric
        Pacco p =servicePacco.creaPacco(uuidCliente,uuidCommerciante);
        Corsa corsa= new Corsa(UUID.randomUUID()/*Corsa*/,
                uuidCorriere,
                p.getIdPacco(),
                uuidBox /*TODO da modificare, do il box anziché il locker --Ric*/);
        serviceCorriere.assegnaCorsa(corsa,uuidCorriere);
        return corsa!=null;//da cambiare una volta implementato bene il metodo.
    }
}
