package Corse;

public class Corsa implements CorsaInterface{

    int idCorriere, idPacco, idLocker, idCorsa;

    public Corsa(int idCorsa, int idCorriere, int idPacco, int idLock) {
        this.idCorsa = idCorsa;
        setLocker(idLocker);
        setCorriere(idCorriere);
        setPacco(idPacco);
    }

    public int getIdCorriere() {
        return idCorriere;
    }
    public int getIdPacco() {
        return idPacco;
    }
    public int getIdLocker() {
        return idLocker;
    }
    public int getIdCorsa() {
        return idCorsa;
    }

    @Override
    public void setCorriere(int idCorriere) {
        this.idCorriere=idCorriere;
    }

    @Override
    public void setLocker(int codiceLocker) {
        this.idLocker = codiceLocker;
    }

    @Override
    public void setPacco(int idPacco) {
        this.idPacco=idPacco;
    }

}
