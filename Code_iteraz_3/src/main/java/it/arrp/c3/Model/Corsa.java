package it.arrp.c3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Questa classe gestisce una Corsa, ossia la consegna di un pacco da un negozio verso
 * un determinato locker. Ne consegue che gestisce principalmente codici identificativi
 * per poter individuare le varie parti.
 */
@Entity
public class Corsa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCorsa;
    private Long idPacco, idLocker, idCorriere;

    public Corsa() {
    }

    public Corsa(Long idCorsa, Long idPacco, Long idLocker, Long idCorriere) {
        this.idCorsa = idCorsa;
        this.idPacco = idPacco;
        this.idLocker = idLocker;
        this.idCorriere = idCorriere;
    }

    public Long getIdCorsa() {
        return idCorsa;
    }
    public void setIdCorsa(Long idCorsa) {
        this.idCorsa = idCorsa;
    }
    public Long getIdPacco() {
        return idPacco;
    }
    public void setIdPacco(Long idPacco) {
        this.idPacco = idPacco;
    }
    public Long getIdLocker() {
        return idLocker;
    }
    public void setIdLocker(Long idLocker) {
        this.idLocker = idLocker;
    }
    public Long getIdCorriere() {
        return idCorriere;
    }
    public void setIdCorriere(Long idCorriere) {
        this.idCorriere = idCorriere;
    }

    @Override
    public String toString() {
        return "Corsa{" +
                "idCorsa=" + idCorsa +
                ", idPacco=" + idPacco +
                ", idLocker=" + idLocker +
                ", idCorriere=" + idCorriere +
                '}';
    }
}
