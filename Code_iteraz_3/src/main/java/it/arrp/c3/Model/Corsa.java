package it.arrp.c3.Model;

import java.util.UUID;

/**
 * Questa classe gestisce una Corsa, ossia la consegna di un pacco da un negozio verso
 * un determinato locker. Ne consegue che gestisce principalmente codici identificativi
 * per poter individuare le varie parti.
 */
public class Corsa {

    UUID idCorriere, idPacco, idLocker, idCorsa;

    public Corsa(UUID idCorsa, UUID idCorriere, UUID idPacco, UUID idLocker) {
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

    public void setCorriere(UUID idCorriere) {
        this.idCorriere=idCorriere;
    }

    public void setLocker(UUID codiceLocker) {
        this.idLocker = codiceLocker;
    }

    public void setPacco(UUID idPacco) {
        this.idPacco=idPacco;
    }

}
