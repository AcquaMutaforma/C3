package Corse;

public class Corsa {
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
