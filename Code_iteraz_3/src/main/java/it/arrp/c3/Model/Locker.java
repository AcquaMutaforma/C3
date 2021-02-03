package it.arrp.c3.Model;

import it.arrp.c3.Locker.BoxInterface;
import it.arrp.c3.Locker.LockerInterface;
import it.arrp.c3.Locker.StatoBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class Locker implements LockerInterface {

    private UUID id;
    private int longitudine;
    private int latitudine;
    private int numeroBox;
    /** Lista dei box che sono contenuti nel Locker */
    private ArrayList<BoxInterface> listaBox;
    /** Mappa di  */
    private HashMap<UUID, BoxInterface> mappaRelazioni;

    public Locker(UUID id, int longitudine, int latitudine, int numeroBox) {
        this.id = id;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.numeroBox = numeroBox;
        this.listaBox = new ArrayList<>();
        this.mappaRelazioni = new HashMap<UUID, BoxInterface>();
    }

    /**
     * Metodo assegnazione Box del locker ad un cliente.
     * @param idCliente .
     * @return false = nessun box disponibile / true = box assegnato al cliente
     */
    @Override
    public boolean assegnaBox(UUID idCliente) {
        BoxInterface b = getBoxDisponibile();
        if(b == null)
            return false;
        else{
            mappaRelazioni.put(idCliente,b);
            return true;
        }
    }

    /**
     * Chiede al Locker di trovare il box collegato al cliente e di generare una chiave.
     * @param idCliente .
     */
    @Override
    public int getChiave(UUID idCliente) {
        return getBoxByClient(idCliente).generaChiave();
        //TODO controllare che abbia senso -ale
    }

    @Override
    public BoxInterface getBoxById(UUID idbox) {
        Iterator<BoxInterface> iter = listaBox.iterator();
        BoxInterface b;
        while (iter.hasNext()){
            b = iter.next();
            if(b.getId().equals(idbox))
                return b;
        }
        return null;
    }

    @Override
    public BoxInterface getBoxByClient(UUID idCliente) {
        return mappaRelazioni.get(idCliente);
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public int getLong() {
        return this.longitudine;
    }

    @Override
    public int getLati() {
        return this.latitudine;
    }

    @Override
    public int getNumeroBox() {
        return this.numeroBox;
    }

    @Override
    public ArrayList<BoxInterface> getAllBoxes() {
        return this.listaBox;
    }

    /**
     * recupera un box dalla lista dei box che abbia stato libero
     *
     * @return Box con stato = libero, altrimenti null.
     */
    @Override
    public BoxInterface getBoxDisponibile() {
        Iterator<BoxInterface> iter = listaBox.iterator();
        BoxInterface b;
        while (iter.hasNext()){
            b = iter.next();
            if(b.getStato() == StatoBox.Libero)
                return b;
        }
        return null;
    }



}