package Corse;

public interface GestoreCorseInterface {
    boolean addCorsa(int idCorriere, int idPacco);
    boolean removeCorsa(int codiceCorsa);
    /*da mettere una intefaccia (come ritorno) per evitare boundaries col codice sviluppato da noi?*/
    //ho creato CorsaInterface e la ho messa qui sotto al posto di Corsa - ale
    CorsaInterface getCorsa(int codiceCorsa);
    boolean setCorsa(int codiceCorsa, int idCorriere, int idPacco, int codiceLocker); //a cosa serve? da vedere
    default boolean creaCorsa(int idCorriere,int idPacco){
        Corsa c = new Corsa(idCorriere,idPacco);
        return c==null;
    }
}
