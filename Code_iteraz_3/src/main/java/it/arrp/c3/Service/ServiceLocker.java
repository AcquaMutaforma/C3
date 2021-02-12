package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;

import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Locker.
 */
public class ServiceLocker {
    ServiceBox serviceBox = new ServiceBox();

    public boolean disattivaBox(UUID uuidBox){
        //TODO da implementare --Ric
        return true;
    }
    public boolean attivaBox(UUID uuidBox){
        //TODO da implementare? l'ho inserito perché mi sembrava giusto ci fosse, poi vediamo --Ric
        return true;
    }
    public Box assegnaBox(UUID uuidCliente){
        //TODO da implementare --Ric
        return serviceBox.assegnaBox(uuidCliente);
    }
    public boolean turnOffLocker(UUID uuidLocker){
        //TODO da implementare --Ric
        return true;
    }
    public boolean turnOnLocker(UUID uuidLocker){
        //TODO da implementare --Ric
        return true;
    }
}
