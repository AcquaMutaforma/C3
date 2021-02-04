package it.arrp.c3.Pacchi;

import it.arrp.c3.Model.Pacco;

import java.util.UUID;

public interface GestorePacchiInterface {

    /** Aggiunge un pacco nella lista di quelli da salvare */
    boolean addPacco(PaccoInterface p);

    /**Rimuove localmente l'oggetto*/
    boolean removePacco(int idPacco);

    PaccoInterface getPacco(int idPacco);

    // boolean savePacco(ArrayList<? extends PaccoInterface> listaPacchi); TODO da fare successivamente.

    default PaccoInterface creaPacco(UUID idPacco, UUID idCommerciante, UUID idCliente){
        PaccoInterface p = new Pacco(idPacco,idCommerciante,idCliente);
        return p;
    }

}