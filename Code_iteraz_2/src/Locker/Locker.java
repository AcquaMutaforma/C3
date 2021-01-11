package Locker;

import java.util.ArrayList;
import java.util.HashMap;

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
     * Metodo assegnazione Box del locker ad un cliente
     *
     * @param idCliente
     */
    @Override
    public void assegnaBox(int idCliente) {

    }

    /**
     * Chiede al Locker di trovare il box collegato al cliente e di generare una chiave
     *
     * @param idCliente
     */
    @Override
    public int GetChiave(int idCliente) {
        return 0;
    }

    @Override
    public BoxInterface getBoxById(int idbox) {
        return null;
    }

    @Override
    public BoxInterface getBoxByClient(int idCliente) {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getLong() {
        return 0;
    }

    @Override
    public int getLati() {
        return 0;
    }

    @Override
    public int getNumeroBox() {
        return 0;
    }

    @Override
    public ArrayList<BoxInterface> getAllBoxes() {
        return null;
    }

    /**
     * recupera un box dalla lista dei box che abbia stato libero
     *
     * @return Box con stato = libero, altrimenti null.
     */
    @Override
    public BoxInterface getBoxDisponibile() {
        return null;
    }
}