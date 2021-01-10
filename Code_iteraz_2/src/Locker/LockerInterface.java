package Locker;

public interface LockerInterface {
    /* Locker ha una lista di BOX che vengono collegati all'id Utenti.Cliente
    * quindi quando il cliente richiede lo stato del box, il locker lo recupera
    * da solo senza il system in base a chi lo sta richiedendo*/

    /** Metodo assegnazione Box del locker ad un cliente */
    void assegnaBox();

    /** getter */
    BoxInterface getBox(int idbox);

    /** Chiede al box inserito di generare una chiave e la ritorna*/
    //TODO per piu box nello stesso locker ?
    int GetChiave(int idCliente);

    //TODO setter & getters
    int getId();
    String getPosizione();
}