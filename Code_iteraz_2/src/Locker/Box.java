package Locker;

public class Box implements BoxInterface{

    //TODO: Per ora il box cambia in automatico da Locked a Unlocked, crea qualcosa per simulare una chiusura etc! -ale

    private final int id;
    private int key;
    private boolean locked;
    private StatoBox stato;

    public Box(int id) {
        this.id = id;
        this.key = 0;
        this.locked = true;
        this.stato = StatoBox.Libero;
    }

    /** Genera una chiave ad uso singolo, se la chiave = 0, allora ne creo una, altrimenti ritorno -1, per
     * innescare una sequenza di errore.
     * Teoricamente la chiave e' 0, finche' il corriere o il cliente non ne genera una per aprire il box.
     * Dopo aver aperto il box, la chiave si resetta. */
    @Override
    public int generaChiave() {
        //TODO fix is needed -ale
        if(this.key == 0) {
            this.key = 1000;
            return this.key;
        }else return -1;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public StatoBox getStato() {
        return this.stato;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    /** Permette di usare la chiave, cambiare stato e aprire il box
     * @param key chiave
     * @return true = chiave corretta + unlocked / false = chiave errata :(
     */
    @Override
    public boolean unlock(int key) {
        if(key == this.key){
            this.locked = false;
            this.avanzaStato();
            this.key = 0;
            return true;
        }else return false;
    }

    /**
     * cambia stato, attesa --> occupato --> libero
     */
    @Override
    public void avanzaStato() {
        if(this.stato == StatoBox.Libero){
            this.stato = StatoBox.Attesa;
        }else if(this.stato == StatoBox.Attesa){
            this.stato = StatoBox.Occupato;
        }else this.stato = StatoBox.Libero;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public void setStato(StatoBox s) {
        this.stato = s;
    }
}
