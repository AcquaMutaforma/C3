package Locker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Locker implements LockerInterface{

    private int id;
    private int longitudine;
    private int latitudine;
    private int numeroBox;
    /** Lista dei box che sono contenuti nel Locker */
    private ArrayList<BoxInterface> listaBox;
    /** Mappa di  */
    private HashMap<Integer, BoxInterface> mappaRelazioni;

    public Locker(int id, int longitudine, int latitudine, int numeroBox) {
        this.id = id;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.numeroBox = numeroBox;
        this.listaBox = new ArrayList<>();
        this.mappaRelazioni = new HashMap<>();
    }

    /**
     * Metodo assegnazione Box del locker ad un cliente.
     * @param idCliente .
     * @return false = nessun box disponibile / true = box assegnato al cliente
     */
    @Override
    public boolean assegnaBox(int idCliente) {
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
    public int getChiave(int idCliente) {
        return getBoxByClient(idCliente).generaChiave();
        //TODO controllare che abbia senso -ale
    }

    @Override
    public BoxInterface getBoxById(int idbox) {
        Iterator<BoxInterface> iter = listaBox.iterator();
        BoxInterface b;
        while (iter.hasNext()){
            b = iter.next();
            if(b.getId() == idbox)
                return b;
        }
        return null;
    }

    @Override
    public BoxInterface getBoxByClient(int idCliente) {
        return mappaRelazioni.get(idCliente);
    }

    @Override
    public int getId() {
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