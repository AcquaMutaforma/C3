package it.arrp.c3.Utenti;

import java.util.UUID;

/**
 * Interfaccia che descrivi un utente generico
 */
public interface UtenteInterface {

    //TODO aggiungere i metodi per modifica profilo.

    //getters
    UUID getID();
    String getNome();
    String getEmail();


    //setters
    boolean setId(UUID i);
    boolean setNome(String n);
    boolean setEmail(String s);

    //todo boolean setPassword(String pass);


    /*TODO: Fare un parser di stringa "lato client" in modo da poterlo stampare
            a video come una lista formattata.*/
}
