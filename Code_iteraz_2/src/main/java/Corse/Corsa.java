package Corse;

public class Corsa implements CorsaInterface{

    int idCorriere, idPacco, codiceLocker;
    //TODO nel costruttore forse andrebbe aggiunto un Locker, altrimenti rimane senza destinazione

    public Corsa(int idCorriere, int idPacco) {
        setCorriere(idCorriere);
        setPacco(idPacco);
    }

    @Override
    public boolean setCorriere(int idCorriere) {
        //TODO opzione false
        this.idCorriere=idCorriere;
        return true;
    }

    @Override
    public boolean setCodice(int codiceLocker) {
        //TODO opzione false
        this.codiceLocker=codiceLocker;
        return true;
    }

    @Override
    public boolean setPacco(int idPacco) {
        //TODO opzione false
        this.idPacco=idPacco;
        return true;
    }
}
