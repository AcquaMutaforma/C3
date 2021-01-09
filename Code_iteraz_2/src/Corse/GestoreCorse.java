package Corse;

public interface GestoreCorse {
    boolean addCorsa();
    boolean removeCorsa();
    /*da mettere una intefaccia (come ritorno) per evitare boundaries col codice sviluppato da noi?*/
    //ho creato CorsaInterface e la ho messa qui sotto al posto di Corsa - ale
    CorsaInterface getCorsa();
    boolean setCorsa(); //a cosa serve? da vedere
}
