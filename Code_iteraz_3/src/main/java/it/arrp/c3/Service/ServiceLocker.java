package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.StatoBox;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

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

    public boolean generaLocker(int longitudine, int latitudine, int dimensioniLocker, String citta){
        if (!verificaDati(latitudine,longitudine, dimensioniLocker)) return false;
        /*se dimensioniLocker è minore o uguale a 0 oppure esiste un locker
        con le stesse coordinate, esce. altrimenti continua.*/
        Locker l = new Locker(longitudine,latitudine,dimensioniLocker, citta);
        popolaLocker(l);
        repoLocker.save(l);
        return true;
    }

    private boolean verificaDati(int longitudine, int latitudine, int dimensioniLocker) {
        return dimensioniLocker > 0 && getLockerByCoords(longitudine, latitudine) == null;
    }

    private Locker getLockerByCoords(int longitudine, int latitudine){
        Point point = new Point(longitudine, latitudine);
        for(Locker l : repoLocker.findAll()){
            if(l.getLocazione() == point)
                return l;
        }
        return null;
    }

    public Locker getLockerById(Long idLocker){
        return repoLocker.findOneByIdLocker(idLocker);
    }

    /* todo sembrano molto inutili, da controllare -A
    public void disattivaBox(Long idBox){
        serviceBox.turnOffBox(idBox);
    }
    public void attivaBox(Long idBox){
        serviceBox.turnOnBox(idBox);
    }
     */

    public Long assegnaBox(Long idCliente){
        Cliente cliente = serviceCliente.getCliente(idCliente);
        Locker locker = cliente.getCheckpoint();
        if( locker == null || locker.getStatoAccensioneLocker() == Accensione.Spento) //nessun checkpoint o locker OFF
            return null;
        Box box = getBoxDisponibile(locker.getIdLocker());
        if(box == null) //box non disponibili nel locker
            return null;
        if(serviceBox.assegnaBox(box.getIdBox(), idCliente).getIdBox() != null){
            serviceCliente.assegnamentoBox(idCliente, box);
            return box.getIdBox();
        }
        return null;
    }

    public void turnOffLocker(Long idLocker){
        Locker locker = getLockerById(idLocker);
        if(locker == null)
            return;
        locker.turnOffLocker();
    }

    public void turnOnLocker(Long idLocker){
        Locker locker = getLockerById(idLocker);
        if(locker == null)
            return;
        locker.turnOnLocker();
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

    /**
     * Questo metodo serve per inserire i box all'interno di un nuovo locker.
     */
    private void popolaLocker(Locker locker){
        int dim = locker.getNumeroBox();
        Box box;
        for(int i = 0; i < dim; i++){
            box = serviceBox.creaBox(locker);
            locker.addBox(box);
        }
    }
}
