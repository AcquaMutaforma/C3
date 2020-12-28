package Persistenza;

/**
 * Definisce le operazioni delle classi che andranno a salvare o caricare dati degli utenti
 */
public interface GestoreUtenti {

    /*I metodi utilizzano una string, che corrisponde alla classe UtenteInterface in formato JSON
    * Ogni tipo di Utente ha bisogno del suo Gestore specifico, dato che hanno campi differenti */

    boolean addUtente(String u);
    boolean rmUtente(String u);
    boolean modificaUtente(String u);
}
