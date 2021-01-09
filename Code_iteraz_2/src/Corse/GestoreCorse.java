package Corse;

public interface GestoreCorse {
    boolean addCorsa();
    boolean removeCorsa();
    /*da mettere una intefaccia (come ritorno) per evitare boundaries col codice sviluppato da noi?*/
    Corsa getCorsa();
    boolean setCorsa(); //a cosa serve? da vedere
}
