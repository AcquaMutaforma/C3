package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.StatoBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/**
 * Classe che gestisce un Locker, dunque la sua posizione geografica (per
 * il momento non reale, ma solo concettualizzata), il numero di Box da cui é composta,
 * una lista degli stessi ed altro ancora.
 */
public class Locker {

    private UUID id;
    private int longitudine;
    private int latitudine;
    private int numeroBox;
    /** Lista dei box che sono contenuti nel Locker */
    private ArrayList<Box> listaBox;
    /** Mappa di  */
    private HashMap<UUID, Box> mappaRelazioni;

    public Locker(UUID id, int longitudine, int latitudine, int numeroBox) {
        this.id = id;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.numeroBox = numeroBox;
        this.listaBox = new ArrayList<>();
        this.mappaRelazioni = new HashMap<UUID, Box>();
    }

    /**
     * Metodo assegnazione Box del locker ad un cliente.
     * @param idCliente .
     * @return false = nessun box disponibile / true = box assegnato al cliente
     */
    public boolean assegnaBox(UUID idCliente) {
        Box b = getBoxDisponibile();
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

    public int getChiave(UUID idCliente) {
        return getBoxByClient(idCliente).generaChiave();
        //TODO controllare che abbia senso -ale
    }


    public Box getBoxById(UUID idbox) {
        Iterator<Box> iter = listaBox.iterator();
        Box b;
        while (iter.hasNext()){
            b = iter.next();
            if(b.getId().equals(idbox))
                return b;
        }
        return null;
    }


    public Box getBoxByClient(UUID idCliente) {
        return mappaRelazioni.get(idCliente);
    }


    public UUID getId() {
        return this.id;
    }


    public int getLong() {
        return this.longitudine;
    }


    public int getLati() {
        return this.latitudine;
    }


    public int getNumeroBox() {
        return this.numeroBox;
    }


    public ArrayList<Box> getAllBoxes() {
        return this.listaBox;
    }

    public void addBox(){
        listaBox.add(new Box(UUID.randomUUID()));
    }

    public void addBox(UUID uuidBox){
        listaBox.add(new Box(uuidBox));
    }

    /**
     * recupera un box dalla lista dei box che abbia stato libero
     *
     * @return Box con stato = libero, altrimenti null.
     */
    public Box getBoxDisponibile() {
        Iterator<Box> iter = listaBox.iterator();
        Box b;
        while (iter.hasNext()){
            b = iter.next();
            if(b.getStato() == StatoBox.Libero)
                return b;
        }
        return null;
    }



}