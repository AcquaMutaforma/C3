package it.arrp.c3.Utenti;
import it.arrp.c3.Locker.*;

public interface ClienteInterface extends UtenteInterface{

    /** Collega Locker.Locker inserito, con il cliente */
    void setCheckpoint(int idlocker); //forse boolean per la risposta

    /** metodo temporaneo, va nella GUI
     * Visualizza il locker che ha come checkpoint o nella lista Lockers*/
    //TODO da rimuovere
    BoxInterface visualizzaBox();

    /*TODO da valutare se il locker va salvato nella cache dell'utente
    *  oppure in un DB*/
}