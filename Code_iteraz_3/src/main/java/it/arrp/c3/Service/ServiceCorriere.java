package it.arrp.c3.Service;

import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.StatoCorriere;

import java.util.List;
import java.util.UUID;

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
}
