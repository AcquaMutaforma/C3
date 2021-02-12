package it.arrp.c3.Service;

import it.arrp.c3.Model.Pacco;

import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Pacco.
 */
public class ServicePacco {

    public Pacco creaPacco(UUID uuidCliente, UUID uuidCommerciante){
        //TODO da controllare (mi sembra troppo semplice e mi mette l'ansia 😅) --Ric
        return new Pacco(UUID.randomUUID(),uuidCommerciante,uuidCliente);
    }
}
