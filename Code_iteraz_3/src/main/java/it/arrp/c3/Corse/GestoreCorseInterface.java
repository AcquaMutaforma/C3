package it.arrp.c3.Corse;

import it.arrp.c3.Model.Corsa;

import java.util.UUID;

public interface GestoreCorseInterface {

    /** Aggiunge una corsa nella lista di quelli da salvare */
    boolean addCorsa(CorsaInterface c);

    /**Rimuove localmente l'oggetto
     * @param codiceCorsa*/
    boolean removeCorsa(UUID codiceCorsa);
    CorsaInterface getCorsa(UUID codiceCorsa);

    //boolean saveCorsa(ArrayList<? extends CorsaInterface> listaCorse); TODO da fare successivamente.

    /** Crea una nuova corsa  */
    default CorsaInterface creaCorsa(UUID idCorsa, UUID idCorriere, UUID idPacco, UUID idLock){
        CorsaInterface c = new Corsa(idCorsa, idCorriere, idPacco, idLock);
        return c;
    }

    //ALE: scusa mi sono permesso di metterci mano, dato che avevamo AddCorsa e CreaCorsa che sembrano la stessa cosa
    //quindi ho diviso i ruoli, ci ho scritto un commento per specificare meglio cosa fanno i metodi
}