package it.arrp.c3.Model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Questa classe rappresenta un Cliente, ovvero un utente registrato, il quale
 * puó effettuare ricerche, richiedere che gli sia consegnato un pacco in un determinato
 * Locker ed altro.
 */
public class Cliente extends UtenteRegistrato {

    //TODO probabilmente conviene mettere id locker e id box, nel db dovrebbe essere piu semplice da leggere
    private Locker lock;
    private Box box;
    public ArrayList<Ruolo> listaRuoli;

    /**
     * Collega Model.Locker inserito, con il cliente
     * @param uuidLocker
     */
    public void setCheckpoint(UUID uuidLocker) {
    }

    /**
     * metodo temporaneo, va nella GUI
     * Visualizza il locker che ha come checkpoint o nella lista Lockers
     */
    public Box visualizzaBox() {
        return null;
    }

}