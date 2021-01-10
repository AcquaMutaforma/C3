package Locker;

import java.util.List;
import java.util.Map;

/** Locker ha una lista di BOX che vengono collegati all'id Utenti.Cliente
 * quindi quando il cliente richiede lo stato del box, il locker lo recupera
 * da solo senza il system in base a chi lo sta richiedendo */
public interface LockerInterface {


    /** Metodo assegnazione Box del locker ad un cliente */
    void assegnaBox(int idCliente);

    /** Chiede al Locker di trovare il box collegato al cliente e di generare una chiave */
    int GetChiave(int idCliente);

    /* --- getters and setters --- */

    BoxInterface getBoxById(int idbox);
    BoxInterface getBoxByClient(int idCliente); //ho dovuto cambiare i nomi dato che sono 2 int e servono entrambi --ale

    int getId();
    int getLong();
    int getLati();
    int getNumeroBox();
    List<BoxInterface> getAllBoxes(); //todo: valutare se va bene la List o se vogliamo usare altro

}