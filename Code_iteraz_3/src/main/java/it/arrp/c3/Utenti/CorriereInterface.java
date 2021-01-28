package it.arrp.c3.Utenti;

public interface CorriereInterface extends UtenteInterface{

    //TODO da rimuovere
    void printCorse();

    //TODO da valutare Corsa nomeCorsa
    boolean rifiutaCorsa(int id);

    void setStato(StatoCorriere s);

    //TODO gestione profilo
}