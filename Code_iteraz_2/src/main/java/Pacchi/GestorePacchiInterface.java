package Pacchi;

public interface GestorePacchiInterface {

    /** Aggiunge un pacco nella lista di quelli da salvare */
    boolean addPacco(PaccoInterface p);

    /**Rimuove localmente l'oggetto*/
    boolean removePacco(int idPacco);

    PaccoInterface getPacco(int idPacco);

    // boolean savePacco(ArrayList<? extends PaccoInterface> listaPacchi); TODO da fare successivamente.

    default PaccoInterface creaPacco(int idPacco, int idCommerciante, int idCliente){
        PaccoInterface p = new Pacco(idPacco,idCommerciante,idCliente);
        return p;
    }

}