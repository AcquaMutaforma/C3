package it.arrp.c3.Locker;

import java.util.UUID;

/**
 * Interfaccia dei box che compongo i Lockers.
 * Il Box ha stato = libero.
 * Il box viene assegnato ad una corsa, stato = attesa.
 * Il box riceve il pacco, stato = occupato.
 * il box viene aperto dal cliente, stato = libero.
 *
 * Il box puo' essere Locked = true, Unlocked = false.
 * Utilizzando una chiave per cambiare stato, il box assume lo stato Unlocked, per poi tornare a Locked
 * Purtroppo bisogna simulare questo "apri e chiudi" dello sportello (magari nella gui) //TODO <-- a sx
 */
public interface BoxInterface {

    /** Genera una chiave ad uso singolo, se la chiave = 0, allora ne creo una, altrimenti ritorno -1, per
     * innescare una sequenza di errore.
     * Teoricamente la chiave e' 0, finche' il corriere o il cliente non ne genera una per aprire il box.
     * Dopo aver aperto il box, la chiave si resetta. */
    int generaChiave();

    UUID getId();
    StatoBox getStato();
    void setStato(StatoBox s);
    boolean isLocked();
    /** Permette di usare la chiave, cambiare stato e aprire il box*/
    boolean unlock(int key);
    /** cambia stato, attesa --> occupato --> libero*/
    void avanzaStato();

    //comandi di supporto, per tecnico, admin e per simulare l'oggetto fisico
    void unlock(); //setStato(false)
    void lock(); //setStato(true)

    //TODO inserire bottoni nelle GUI per simulare l'apertura e chiusura del box
    //TODO Da decidere come notifica gli utenti, forse il locker riceve la notifica dal box, e lui notifica il SYSTEM
}