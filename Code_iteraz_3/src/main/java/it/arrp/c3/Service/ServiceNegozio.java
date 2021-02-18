package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Negozio;

import java.util.List;
import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti il Ruolo Negozio.
 */
public class ServiceNegozio {
    ServiceCliente serviceCliente = new ServiceCliente();
    ServiceCorsa serviceCorsa = new ServiceCorsa();

    public boolean addCorriere(UUID uuidCorriere){
        //TODO da implementare --Ric
        return true;
    }
    public boolean removeCorriere(UUID uuidCorriere){
        //TODO da implementare --Ric
        return true;
    }
    public UUID getCorriereDisponibile(){
        //TODO da implementare --Ric
        return null;
    }
    public boolean creaCorsa(UUID uuidCliente, UUID uuidCommerciante){
        UUID corriere =getCorriereDisponibile();
        if (corriere!=null){
            //da verificare se lasciarlo o meno, va a cozzare con il sequence diagram se si controlla quì il corriere. --Ric
            Box box =serviceCliente.getBoxCliente(uuidCliente);
            if(serviceCorsa.creaCorsa(uuidCliente,uuidCommerciante, corriere, box.getId())&&box!=null)
                return true;
        }
        return false; //di conseguenza la consegna viene negata
        //TODO da completare --Ric
    }

    public List<Negozio> getNegozi(String citta) {
        //TODO
        return null;
    }

    public List<Negozio> getNegozioByName(String citta, String nome) {
        //TODO
        return null;
    }

    public List<Negozio> getNegozioByGenere(String citta, GenereNegozio genere) {
        //TODO
        return null;
    }
}
