package it.arrp.c3.Model;
import it.arrp.c3.Locker.*;
import it.arrp.c3.Utenti.ClienteInterface;

import java.util.UUID;

public class Cliente extends UtenteRegistrato implements ClienteInterface {

    //TODO probabilmente conviene mettere id locker e id box, nel db dovrebbe essere piu semplice da leggere
    private LockerInterface lock;
    private BoxInterface box;

    /**
     * Collega Locker.Locker inserito, con il cliente
     * @param idlocker
     */
    @Override
    public void setCheckpoint(int idlocker) {
    }

    /**
     * metodo temporaneo, va nella GUI
     * Visualizza il locker che ha come checkpoint o nella lista Lockers
     */
    @Override
    public BoxInterface visualizzaBox() {
        return null;
    }

    @Override
    public UUID getID() {
        return null;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public boolean setId(UUID i) {
        return false;
    }

    @Override
    public boolean setNome(String n) {
        return false;
    }

    @Override
    public boolean setEmail(String s) {
        return false;
    }
}