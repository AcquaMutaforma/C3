package Corse;

public interface GestoreCorseInterface {

    /** Aggiunge una corsa nella lista di quelli da salvare */
    boolean addCorsa(CorsaInterface c);

    /**Rimuove localmente l'oggetto*/
    boolean removeCorsa(int codiceCorsa);
    CorsaInterface getCorsa(int codiceCorsa);

    //boolean saveCorsa(ArrayList<? extends CorsaInterface> listaCorse); TODO da fare successivamente.

    /** Crea una nuova corsa  */
    default CorsaInterface creaCorsa(int idCorsa, int idCorriere,int idPacco, int idLock){
        CorsaInterface c = new Corsa(idCorsa, idCorriere, idPacco, idLock);
        return c;
    }

    //ALE: scusa mi sono permesso di metterci mano, dato che avevamo AddCorsa e CreaCorsa che sembrano la stessa cosa
    //quindi ho diviso i ruoli, ci ho scritto un commento per specificare meglio cosa fanno i metodi
}