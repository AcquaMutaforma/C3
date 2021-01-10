package Utenti;

/**
 * Definisce le operazioni delle classi che andranno a salvare o caricare dati degli utenti
 */
public interface GestoreUtenti {

    /*I metodi utilizzano una string, che corrisponde alla classe UtenteInterface in formato JSON
    * Ogni tipo di Utente ha bisogno del suo Gestore specifico, dato che hanno campi differenti */

    /*dovremmo lasciare alla view la responsabilità di prende in input i dati, e creare l'oggetto.
    * ma dovremmo comunque fare un controllo della stringa o oggetto per capire il tipo di utente che viene creato per inserirlo
    * nel posto giusto, per questo motivo avevo pensato ad un metodo differente per ogni tipo di utente --ale */

    boolean addUtente(String u);
    boolean rmUtente(String u);
    boolean modificaUtente(String u);
}
