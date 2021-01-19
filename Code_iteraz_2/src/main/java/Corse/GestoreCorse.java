package Corse;

public class GestoreCorse implements GestoreCorseInterface {

    //TODO aggiungere le variabili -ale

    @Override
    public boolean addCorsa(int idCorriere, int idPacco) {
        return creaCorsa(idCorriere,idPacco);
    }

    @Override
    public boolean removeCorsa(int codiceCorsa) {
        //TODO correggere o ritorna sempre null
        CorsaInterface c =getCorsa(codiceCorsa);
        c=null;     /*non sono sicuro, ma in linea teorica dovrebbe eliminare il riferimento all'oggetto, quindi
                    (presto o tardi) arriva il garbage collector e lo cestina. | Riccardo */
        return c == null;
        //ho lasciato questa dicitura anziché semplificare poiché non é
        // finita l'implementazione sopra | Riccardo
    }

    @Override
    public CorsaInterface getCorsa(int codiceCorsa) {
        //TODO
        //non so sinceramente come implementarlo. da dove prendo effettivamente la corsa? | Riccardo
        return null;
    }

    /* TODO: probabilmente non serve, ora lasciamolo qui -ale
    @Override
    public boolean setCorsa(int codiceCorsa, int idCorriere, int idPacco, int codiceLocker) {
        CorsaInterface c = getCorsa(codiceCorsa);
        return c.setCorriere(idCorriere) &&
                c.setPacco(idPacco) &&
                c.setCodice(codiceLocker);
    }

     */
}
