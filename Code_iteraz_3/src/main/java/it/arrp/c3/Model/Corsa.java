package it.arrp.c3.Model;

import it.arrp.c3.Corse.CorsaInterface;

import java.util.UUID;

public class Corsa implements CorsaInterface {

    UUID idCorriere, idPacco, idLocker, idCorsa;

    public Corsa(UUID idCorsa, UUID idCorriere, UUID idPacco, UUID idLocker) {
        //TODO refactoring del costruttore, prende troppe cose che non dovrebbe
        // (guardare class diagram, metodi di creazione corse) --Ric
        this.idCorsa = idCorsa;
        setLocker(idLocker);
        setCorriere(idCorriere);
        setPacco(idPacco);
    }

    public UUID getIdCorriere() {
        return idCorriere;
    }
    public UUID getIdPacco() {
        return idPacco;
    }
    public UUID getIdLocker() {
        return idLocker;
    }
    public UUID getIdCorsa() {
        return idCorsa;
    }

    @Override
    public void setCorriere(UUID idCorriere) {
        this.idCorriere=idCorriere;
    }

    @Override
    public void setLocker(UUID codiceLocker) {
        this.idLocker = codiceLocker;
    }

    @Override
    public void setPacco(UUID idPacco) {
        this.idPacco=idPacco;
    }

}
