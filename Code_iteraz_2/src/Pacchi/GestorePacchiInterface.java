package Pacchi;

public interface GestorePacchiInterface {
    boolean addPacco(int idCommerciante, int idCliente);
    boolean removePacco(int idPacco);
    /*da mettere una intefaccia, al posto di Pacco, per evitare boundaries col codice sviluppato da noi?*/
    Pacco getPacco(int idPacco);
    boolean setPacco(int idPacco, int idCommerciante, int idCliente); //a cosa serve? da vedere
    default boolean creaPacco(int idCommerciante, int idCliente){
        Pacco p = new Pacco(idCommerciante,idCliente);
        return p==null;
    }

}
