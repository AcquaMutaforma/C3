package Corse;

public interface GestoreCorseInterface {

    boolean addCorsa(int idCorriere, int idPacco);
    boolean removeCorsa(int codiceCorsa);
    CorsaInterface getCorsa(int codiceCorsa);
    //boolean setCorsa(int codiceCorsa, int idCorriere, int idPacco, int codiceLocker); //probabilmente non serve
    default boolean creaCorsa(int idCorriere,int idPacco){
        Corsa c = new Corsa(idCorriere,idPacco);
        return c==null;
    }
}
