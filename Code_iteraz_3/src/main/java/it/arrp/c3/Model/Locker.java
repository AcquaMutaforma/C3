package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.Accensione;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe che gestisce un Locker, dunque la sua posizione geografica (per
 * il momento non reale, ma solo concettualizzata), il numero di Box da cui é composta,
 * una lista degli stessi ed altro ancora.
 */
@Entity
@Table(name = "locker")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLocker")
    private Long idLocker;
    @Column(name="ubicazione")
    private Point locazione;
    @Column(name="numeroBox")
    private int numeroBox;
    @Column(name="citta")
    private String citta;

    private Accensione statoAccensioneLocker;
    /** Lista dei box che sono contenuti nel Locker */
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Box> listaBox =  new ArrayList<Box>();

    public Locker() {
    }

    public Locker(int longitudine, int latitudine, int numeroBox, String citta) {
        this.locazione = new Point(longitudine, latitudine);
        this.numeroBox = numeroBox;
        this.citta = citta;
        this.statoAccensioneLocker = Accensione.Acceso;

    }

    public void turnOnLocker(){
        this.statoAccensioneLocker= Accensione.Acceso;
    }
    public void turnOffLocker(){
        this.statoAccensioneLocker= Accensione.Spento;
    }

    public void setIdLocker(Long idLocker) {
        this.idLocker = idLocker;
    }

    public Point getLocazione() { return this.locazione;}

    public void setLocazione(int x, int y) { this.locazione = new Point(x,y); }

    public void setStatoAccensioneLocker(Accensione statoAccensioneLocker) {
        this.statoAccensioneLocker = statoAccensioneLocker;
    }

    public void setNumeroBox(int numeroBox) {
        this.numeroBox = numeroBox;
    }
    public Long getIdLocker() {
        return this.idLocker;
    }
    public int getNumeroBox() {
        return this.numeroBox;
    }
    public List<Box> getAllBoxes() {
        return this.listaBox;
    }
    public void addBox(Box b){
        listaBox.add(b);
    }
    public boolean removeBox(Box b){
        return listaBox.remove(b);
    }
    public Accensione getStatoAccensioneLocker() {
        return statoAccensioneLocker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locker)) return false;
        Locker locker = (Locker) o;
        return getIdLocker().equals(locker.getIdLocker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdLocker());
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + idLocker +
                ", longitudine=" + this.locazione.x +
                ", latitudine=" + this.locazione.y +
                ", numeroBox=" + numeroBox +
                '}';
    }

    public String getCitta() {
        return this.citta;
    }
}