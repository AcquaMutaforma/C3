package Corse;

public class Corsa implements CorsaInterface{
    int idCorriere, idPacco, codiceLocker;
    public Corsa(int idCorriere, int idPacco) {
        setCorriere(idCorriere);
        setPacco(idPacco);
    }

    @Override
    public boolean setCorriere(int idCorriere) {
        this.idCorriere=idCorriere;
        return true;
    }

    @Override
    public boolean setCodice(int codiceLocker) {
        this.codiceLocker=codiceLocker;
        return true;
    }

    @Override
    public boolean setPacco(int idPacco) {
        this.idPacco=idPacco;
        return true;
    }
}
