package it.arrp.c3.Model;

import javax.persistence.*;

/**
 * Questa classe gestisce una Corsa, ossia la consegna di un pacco da un negozio verso
 * un determinato locker. Ne consegue che gestisce principalmente codici identificativi
 * per poter individuare le varie parti.
 */
@Entity
public class Corsa {

    @Id
    @Column(name="idCorsa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCorsa;
    @Column(name = "idPacco")
    private Long idPacco;
    @Column(name = "idBox")
    private Long idBox;
    @Column(name = "idCorriere")
    private Long idCorriere;    //Nota: l'IDnegozio lo peschi dal pacco di cui hai l'id

    //TODO da valutare se inserire lo "stato" della corsa, come completata, fallita e onGoing(da cambiare anche i nomi)
    // -A

    public Corsa() {
    }

    public Corsa(Long idPacco, Long idBox, Long idCorriere) {
        setIdPacco(idPacco);
        setIdBox(idBox);
        setIdCorriere(idCorriere);
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
    public Long getIdBox() {
        return idBox;
    }
    public void setIdBox(Long idBox) {
        this.idBox = idBox;
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
                ", idBox=" + idBox +
                ", idCorriere=" + idCorriere +
                '}';
    }
}
