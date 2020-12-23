package Locker;

/**
 * Interfaccia dei box che compongo i Lockers
 */
public interface BoxInterface {

    int GeneraChiave();
    int getId();

    StatoBox getStato();

    /*
    Il Box viene "prenotato", cambia stato chiamato dal System.
    Il Box quando viene aperto, cambia stato da solo con questo metodo. */
    //TODO Da decidere come notifica gli utenti, forse il locker riceve la notifica dal box, e lui notifica il SYSTEM
    //Dato che non abbiamo l'oggetto fisico, lo simuliamo così.
    boolean setStato(StatoBox s);

    //TODO inserire bottoni nelle GUI per simulare l'apertura e chiusura del box
}