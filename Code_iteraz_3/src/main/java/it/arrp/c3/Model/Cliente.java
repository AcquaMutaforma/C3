package it.arrp.c3.Model;

import java.util.UUID;

public class Cliente extends UtenteRegistrato {

    //TODO probabilmente conviene mettere id locker e id box, nel db dovrebbe essere piu semplice da leggere
    private Locker lock;
    private Box box;

    /**
     * Collega Locker.Locker inserito, con il cliente
     * @param idlocker
     */
    public void setCheckpoint(int idlocker) {
    }

    /**
     * metodo temporaneo, va nella GUI
     * Visualizza il locker che ha come checkpoint o nella lista Lockers
     */
    public Box visualizzaBox() {
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
    public boolean setUuid(UUID i) {
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