package Locker;

import java.util.ArrayList;
import java.util.HashMap;

public class Locker implements LockerInterface{

    private int id;
    private int Longitudine;
    private int Latitudine;
    private int numeroBox;
    private ArrayList<BoxInterface> boxDisponibili;
    private HashMap<Integer, BoxInterface> mappaRelazioni;

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
}