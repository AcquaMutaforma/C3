package Locker;


/**
 * Definisce le operazioni delle classi che andranno a salvare o caricare dati dei Lockers
 */
public interface GestoreLocker {

    LockerInterface seedProtocol();
    LockerInterface getLocker();
    boolean removeLocker();
    //probabilmente non serve a una mazza -ale | boolean setLocker();
    boolean addLocker(int id);
}