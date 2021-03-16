package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;

import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Locker.
 */
public class ServiceLocker {
    ServiceBox serviceBox = new ServiceBox();

    public boolean disattivaBox(Long uuidBox){
        //TODO da implementare --Ric
        return true;
    }
    public boolean attivaBox(Long uuidBox){
        //TODO da implementare? l'ho inserito perché mi sembrava giusto ci fosse, poi vediamo --Ric
        return true;
    }
    public Box assegnaBox(Long uuidCliente){
        //TODO da implementare --Ric
        return serviceBox.assegnaBox(uuidCliente);
    }
    public boolean turnOffLocker(Long uuidLocker){
        //TODO da implementare --Ric
        return true;
    }
    public boolean turnOnLocker(Long uuidLocker){
        //TODO da implementare --Ric
        return true;
    }
}
