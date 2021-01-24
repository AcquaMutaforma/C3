package Locker;


/**
 * Definisce le operazioni delle classi che andranno a salvare o caricare dati dei Lockers
 */
public interface GestoreLockerInterface {

    LockerInterface getLocker();

    /**Da rimuovere*/
    boolean addLocker(LockerInterface l);

    default LockerInterface creaLocker(int id, int longitudine, int latitudine, int numeroBox){
        LockerInterface l = new Locker( id,  longitudine,  latitudine,  numeroBox);
        return l;
    }

    boolean salvaTutto();
}