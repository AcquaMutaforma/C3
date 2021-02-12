package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.StatoBox;

import java.util.UUID;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity

/**
 * Questa classe ha la responsabilità di gestire un singolo Box facente parte di
 * un Locker. Ne consegue che gestirà il proprio stato, la chiave di apertura
 * e, per questa implementazione, anche la sua apertura/chiusura simulata.
 */
public class Box{

    //TODO: Per ora il box cambia in automatico da Locked a Unlocked, crea qualcosa per simulare una chiusura etc! -ale

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

    private int key;
    private boolean locked;
    private StatoBox stato;

    public Box(UUID id) {
        this.id = id;
        this.key = 0;
        this.locked = true;
        this.stato = StatoBox.Libero;
    }

    /** Genera una chiave ad uso singolo, se la chiave = 0, allora ne creo una, altrimenti ritorno -1, per
     * innescare una sequenza di errore.
     * Teoricamente la chiave e' 0, finche' il corriere o il cliente non ne genera una per aprire il box.
     * Dopo aver aperto il box, la chiave si resetta. */
    public int generaChiave() {
        //TODO fix is needed -ale
        if(this.key == 0) {
            this.key = 1000;
            return this.key;
        }else return -1;
    }

    public UUID getId() {
        return this.id;
    }

    public StatoBox getStato() {
        return this.stato;
    }

    public boolean isLocked() {
        return this.locked;
    }

    /** Permette di usare la chiave, cambiare stato e aprire il box
     * @param key chiave
     * @return true = chiave corretta + unlocked / false = chiave errata :(
     */
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
    public void avanzaStato() {
        switch (stato){
            case Libero: this.stato=StatoBox.Attesa;
            case Attesa: this.stato = StatoBox.Occupato;
            case Occupato: this.stato = StatoBox.Libero;
        }
    }

    public void unlock() {
        this.locked = false;
    }

    public void lock() {
        this.locked = true;
    }

    public void setStato(StatoBox s) {
        this.stato = s;
    }
}