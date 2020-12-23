package Utenti;

/**
 * Interfaccia che descrivi un utente generico
 */
public interface UtenteInterface {

    //TODO aggiungere i metodi per modifica profilo.

    //getters
    int getID();
    String getNome();

    //setters
    boolean setId(int i);
    boolean setNome(String n);

    /*TODO: Fare un parser di stringa "lato client" in modo da poterlo stampare
            a video come una lista formattata.*/
}
