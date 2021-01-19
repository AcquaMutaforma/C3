package Pacchi;

public interface GestorePacchiInterface {

    boolean addPacco(int idCommerciante, int idCliente);
    boolean removePacco(int idPacco);
    PaccoInterface getPacco(int idPacco);
    //boolean setPacco(int idPacco, int idCommerciante, int idCliente); //a cosa serve? da vedere  // ale: probabilmente non serve

    default boolean creaPacco(int idCommerciante, int idCliente){
        Pacco p = new Pacco(idCommerciante,idCliente);
        return p==null;
    }
    //TODO ale: scusa ma se poi fai l'override tanto vale non implementarlo qui ahah

}