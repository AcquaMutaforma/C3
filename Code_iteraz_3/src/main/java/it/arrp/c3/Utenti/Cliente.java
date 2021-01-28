package it.arrp.c3.Utenti;
import it.arrp.c3.Locker.*;

public class Cliente implements ClienteInterface{

    private int id;
    private String nome;
    private String email;
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
    public int getID() {
        return 0;
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
    public boolean setId(int i) {
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