package Corse;

public class Corsa implements CorsaInterface{

    int idCorriere, idPacco, codiceLocker, idCorsa;
    //TODO nel costruttore forse andrebbe aggiunto un Locker, altrimenti rimane senza destinazione

    public Corsa(int idCorriere, int idPacco) {
        setCorriere(idCorriere);//TODO e se questi setters fossero privati?
        setPacco(idPacco);
    }

    @Override
    public boolean setCorriere(int idCorriere) {
        //TODO opzione false o diventa void?
        this.idCorriere=idCorriere;
        return true;
    }

    @Override
    public boolean setCodice(int codiceLocker) {
        //TODO opzione false o diventa void?
        this.codiceLocker=codiceLocker;
        return true;
    }

    @Override
    public boolean setPacco(int idPacco) {
        //TODO opzione false o diventa void?
        this.idPacco=idPacco;
        return true;
    }

    @Override
    public boolean setIdCorsa(int idCorsa) {
        //TODO opzione false o diventa void?
        this.idCorsa=idCorsa;
        return true;
    }
}
