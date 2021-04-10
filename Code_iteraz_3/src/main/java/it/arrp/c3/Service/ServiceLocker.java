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

    public boolean disattivaBox(Long idBox){
        return  serviceBox.turnOffBox(idBox);
    }
    public boolean attivaBox(Long idBox){
        return serviceBox.turnOnBox(idBox);
    }
    public Box assegnaBox(Long idCliente){
        //TODO da implementare --Ric
        return serviceBox.assegnaBox(idCliente);
    }
    public boolean turnOffLocker(Long idLocker){
        repoLocker.findOneById(idLocker).turnOffLocker();
        return true;
    }
    public boolean turnOnLocker(Long idLocker){
        repoLocker.findOneById(idLocker).turnOnLocker();
        return true;
    }
}
