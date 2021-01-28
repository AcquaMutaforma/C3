package it.arrp.c3.Utenti;

public interface CommercianteINNterface {

    /** da definire come prende gli argomenti */
    void creazioneConsegna(int idcliente, int idLocker);

    //TODO valutare se fare (Corriere Corriere)
    boolean addCorriere(int id);
    boolean rmCorriere(int id);

    //TODO da rimuovere
    void printCorrieri();

    //TODO valutare se fare (Prodotto prodotto)
    boolean addProdotto(int id);
    boolean rmProdotto(int id);

    //TODO da rimuovere
    void printProdotti();

    //setters
    void setIndirizzo(String s);

    //getters
    String getIndirizzo();
}
