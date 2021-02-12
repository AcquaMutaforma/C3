package it.arrp.c3.Service;

import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Enum.StatoCorriere;

import java.util.List;
import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Corriere.
 */
public class ServiceCorriere {

    public List<Corsa> getCorse(){
        //TODO da implementare, forse prende un UUID del corriere? --Ric
        return null;
    }
    public boolean rifiutaCorsa(UUID uuidCorsa){
        //TODO da implementare --Ric
        return true;
    }
    public void cambiaStato(StatoCorriere statoCorriere){
        //TODO da implementare, anche qui penso debba prendere lo UUID del corriere --Ric
    }

    public void assegnaCorsa(Corsa corsa, UUID uuidCorriere) {
        Corriere corriere=getCorriere(uuidCorriere);
        //TODO da implementare --Ric

    }

    public Corriere getCorriere(UUID uuidCorriere){
        //TODO da implementare? penso abbia senso --Ric
        return null;
    }
}
