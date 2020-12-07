public interface ClienteInterface extends UtenteInterface{

    /** Collega Locker inserito, con il cliente */
    void setCheckpoint(String s); //forse boolean per la risposta

    int getCodiceCliente();

    /** metodo temporaneo, va nella GUI
     * Visualizza il locker che ha come checkpoint o nella lista Lockers*/
    BoxInterface visualizzaBox();

    /*TODO da valutare se il locker va salvato nella cache dell'utente
    *  oppure in un DB*/
}
