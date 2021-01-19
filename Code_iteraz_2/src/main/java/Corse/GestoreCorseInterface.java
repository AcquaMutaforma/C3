package Corse;

import java.util.ArrayList;

public interface GestoreCorseInterface {

    boolean addCorsa(int idCorriere, int idPacco);
    boolean removeCorsa(int codiceCorsa);
    CorsaInterface getCorsa(int codiceCorsa);
    boolean saveCorsa(ArrayList<? extends CorsaInterface> listaCorse);
    //boolean setCorsa(int codiceCorsa, int idCorriere, int idPacco, int codiceLocker); //probabilmente non serve
    default Corsa creaCorsa(int idCorriere,int idPacco){
        //TODO c'é un legame con la nostra implementazione, da togliere in qualche modo
        Corsa c = new Corsa(idCorriere,idPacco);
        return c;
    }
}
