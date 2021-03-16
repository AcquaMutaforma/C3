package it.arrp.c3.Service;

import it.arrp.c3.Model.Pacco;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Pacco.
 */
@Service
public class ServicePacco {

    public Pacco creaPacco(long uuidCliente, long uuidCommerciante){
        //TODO da controllare (mi sembra troppo semplice e mi mette l'ansia 😅) --Ric
        return new Pacco((long)(Math.random()*100),uuidCommerciante,uuidCliente);
    }
}
