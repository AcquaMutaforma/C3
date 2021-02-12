package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;

import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Box.
 */
public class ServiceBox {

    public Box assegnaBox(UUID uuidCliente){
        //TODO da implementare --Ric
        return new Box(UUID.randomUUID());
    }
    public boolean liberaBox(){
        //TODO da implementare (forse diventa void?) --Ric
        return true;
    }
    public void generaChiave(){
        //TODO da implementare (da aggiungere un getChiave a questo punto?) --Ric
    }
    public boolean unlock(int chiave){
        //TODO da implementare --Ric
        return true;
    }
    public boolean lock(){
        //TODO da implementare --Ric
        return true;
    }
    public boolean turnOffBox(UUID uuidBox){
        //TODO da implementare --Ric
        return true;
    }
    public boolean turnOnBox(UUID uuidBox){
        //TODO da implementare --Ric
        return true;
    }
}
