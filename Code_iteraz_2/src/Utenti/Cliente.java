package Utenti;
import Locker.*;

public class Cliente implements ClienteInterface{

    LockerInterface lock;
    BoxInterface box;

    /**
     * Collega Locker.Locker inserito, con il cliente
     * @param s
     */
    @Override
    public void setCheckpoint(String s) {
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
    public boolean setId(int i) {
        return false;
    }

    @Override
    public boolean setNome(String n) {
        return false;
    }
}
