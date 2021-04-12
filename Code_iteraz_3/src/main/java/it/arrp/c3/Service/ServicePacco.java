package it.arrp.c3.Service;

import it.arrp.c3.Model.Pacco;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Pacco.
 */
@Service
public class ServicePacco {

    public Pacco creaPacco(long idCliente, long idCommerciante){
        //TODO Da controllare la chiamata al costruttore Pacco --Ric
        return new Pacco(idCommerciante,idCliente);
    }
}
