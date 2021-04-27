package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.StatoBox;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Locker.
 */
@Service
public class ServiceLocker {

    @Autowired
    LockerRepository repoLocker;

    @Autowired
    ServiceBox serviceBox;
    @Autowired
    ServiceCliente serviceCliente;

    public boolean generaLocker(int latitudine, int longitudine, int dimensioniLocker){
        //TODO penso sia completo il metodo, verificaDati incluso... da controllare --Ric
        if (!verificaDati(latitudine,longitudine, dimensioniLocker)) return false;
        /*se dimensioniLocker è minore o uguale a 0 oppure esiste un locker
        con le stesse coordinate, esce. altrimenti continua.*/
        new Locker(longitudine,latitudine,dimensioniLocker);
        return true;
    }

    private boolean verificaDati(int latitudine, int longitudine, int dimensioniLocker) {
        //TODO in realta' le coordinate possono essere anche negative -A
        return dimensioniLocker > 0 && getLockerByCoords(latitudine, longitudine) == null;
    }

    private Locker getLockerByCoords(int latitudine, int longitudine){ //TODO da implementare --Ric
//TODO restituire il locker con lati. e long. passati come argomento (null se non esiste) cercando nel repo.(query sql?) --Ric
        return null;
    }

    public Locker getLockerById(Long idLocker){
        return repoLocker.findOneById(idLocker);
    }

    public void disattivaBox(Long idBox){
        serviceBox.turnOffBox(idBox);
    }
    public void attivaBox(Long idBox){
        serviceBox.turnOnBox(idBox);
    }

    public Long assegnaBox(Long idCliente){
        Cliente cliente = serviceCliente.getCliente(idCliente);
        Locker locker = cliente.getCheckpoint();
        if(locker == null || locker.getStatoAccensioneLocker() == Accensione.Spento) //nessun checkpoint o locker OFF
            return null;
        Box box = getBoxDisponibile(locker.getId());
        if(box == null) //box non disponibili nel locker
            return null;
        return serviceBox.assegnaBox(box.getIdBox(), idCliente).getIdBox();
    }

    public boolean turnOffLocker(Long idLocker){
        repoLocker.findOneById(idLocker).turnOffLocker();
        return true;
    }

    public boolean turnOnLocker(Long idLocker){
        repoLocker.findOneById(idLocker).turnOnLocker();
        return true;
    }

    public Box getBoxDisponibile(Long idLocker){
        Locker locker = getLockerById(idLocker);
        if(locker == null || locker.getStatoAccensioneLocker() == Accensione.Spento)
            return null;
        for(Box b : locker.getAllBoxes()){
            if(b.getStato() == StatoBox.Libero && b.getStatoAccensioneBox() == Accensione.Acceso)
                return b;
        }
         return null;
    }
}
