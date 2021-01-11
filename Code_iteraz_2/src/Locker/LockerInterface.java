package Locker;

import java.util.ArrayList;

/** Locker ha una lista di BOX che vengono collegati all'id Utenti.Cliente
 * quindi quando il cliente richiede lo stato del box, il locker lo recupera
 * da solo senza il system in base a chi lo sta richiedendo */
public interface LockerInterface {

    /** Metodo assegnazione Box del locker ad un cliente */
    boolean assegnaBox(int idCliente);

    /** Chiede al Locker di trovare il box collegato al cliente e di generare una chiave */
    int getChiave(int idCliente);

    //TODO SUPERMEGAPROBLEMA: Chi crea i box per il locker? se stesso o il Gestore? comunque sia devono parlare con GestoreId per ricevere ID nuovi.

    /* --- getters and setters --- */

    BoxInterface getBoxById(int idbox);
    BoxInterface getBoxByClient(int idCliente); //ho dovuto cambiare i nomi dato che sono 2 int e servono entrambi --ale

    int getId();
    int getLong();
    int getLati();
    int getNumeroBox(); //numero dei box che appartengono al Locker
    ArrayList<BoxInterface> getAllBoxes(); //todo: valutare se va bene la List o se vogliamo usare un array

    /**
     * recupera un box dalla lista dei box che abbia stato libero
     * @return Box con stato = libero, altrimenti null.
     */
    BoxInterface getBoxDisponibile();

}