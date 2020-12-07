public class Cliente implements ClienteInterface{

    LockerInterface lock;
    BoxInterface box;

    /**
     * Collega Locker inserito, con il cliente
     *
     * @param s
     */
    @Override
    public void setCheckpoint(String s) {

    }

    @Override
    public int getCodiceCliente() {
        return 0;
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
    public String ricercaNegozio(String neg) {
        return null;
    }

    @Override
    public String ricercaArticolo(String art) {
        return null;
    }
}
