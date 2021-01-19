package Pacchi;

import java.util.ArrayList;

public interface GestorePacchiInterface {

    boolean addPacco(int idCommerciante, int idCliente);
    boolean removePacco(int idPacco);
    PaccoInterface getPacco(int idPacco);
    int getNewId ();
    boolean savePacco(ArrayList<? extends PaccoInterface> listaPacchi);
    //boolean setPacco(int idPacco, int idCommerciante, int idCliente); //a cosa serve? da vedere  // ale: probabilmente non serve

    default Pacco creaPacco(int idCommerciante, int idCliente){
        //TODO c'é un legame con la nostra implementazione, da togliere in qualche modo
        Pacco p = new Pacco(idCommerciante,idCliente);
        return p;
    }
    //TODO ale: scusa ma se poi fai l'override tanto vale non implementarlo qui ahah
    /*TODO Ricc: non c'é l'override di questo metodo, ho pensato di dare una implementazione di
            default "anche a chi usa le nostre classi" (anche se poi non c'é nessuno che le userá)*/

}