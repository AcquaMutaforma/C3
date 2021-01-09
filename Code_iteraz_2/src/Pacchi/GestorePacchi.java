package Pacchi;

public interface GestorePacchi {
    boolean addPacco();
    boolean removePacco();
    /*da mettere una intefaccia, al posto di Pacco, per evitare boundaries col codice sviluppato da noi?*/
    Pacco getPacco();
    boolean setPacco(); //a cosa serve? da vedere

}
