package it.arrp.c3.Service;

import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Pacco;

import java.util.UUID;

public class ServiceCorsa {
    ServicePacco servicePacco= new ServicePacco();

    public void creaCorsa(UUID uuidCliente, UUID uuidCommerciante,UUID uuidCorriere, UUID uuidBox){
        //TODO da implementare --Ric
        Pacco p =servicePacco.creaPacco(uuidCliente,uuidCommerciante);
        new Corsa(UUID.randomUUID()/*Corsa*/,
                uuidCorriere,
                p.getIdPacco(),
                uuidBox /*TODO da modificare, do il box anziché il locker --Ric*/);
    }
}
