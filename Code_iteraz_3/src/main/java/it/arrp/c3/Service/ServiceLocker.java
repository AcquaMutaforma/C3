package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Locker.
 */
@Service
public class ServiceLocker {

    @Autowired
    LockerRepository repoLocker;

    @Autowired
    ServiceBox serviceBox;

    public  boolean generaLocker(int latitudine, int longitudine, int dimensioniLocker){
        //TODO penso sia completo il metodo, verificaDati incluso... da controllare --Ric
        if (!verificaDati(latitudine,longitudine, dimensioniLocker)) return false;
        /*se dimensioniLocker è minore o uguale a 0 oppure esiste un locker
        con le stesse coordinate, esce. altrimenti continua.*/
        new Locker(longitudine,latitudine,dimensioniLocker);
        return true;
    }

    private boolean verificaDati(int latitudine, int longitudine, int dimensioniLocker) {
        return dimensioniLocker > 0 && getLockerByCoords(latitudine, longitudine) == null;
    }

    private Locker getLockerByCoords(int latitudine, int longitudine){ //TODO da implementare --Ric
//TODO restituire il locker con lati. e long. passati come argomento (null se non esiste) cercando nel repo. --Ric
        return null;
    }

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
