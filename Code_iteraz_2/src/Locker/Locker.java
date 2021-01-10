package Locker;

public class Locker implements LockerInterface{


    /**
     * Metodo assegnazione Box del locker ad un cliente
     */
    @Override
    public void assegnaBox() {
        
    }

    /**
     * getter
     *
     * @param idbox
     */
    @Override
    public BoxInterface getBox(int idbox) {
        return null;
    }

    /**
     * Chiede al box inserito di generare una chiave e la ritorna
     *
     * @param idCliente
     */
    @Override
    public int GetChiave(int idCliente) {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getPosizione() {
        return null;
    }
}
