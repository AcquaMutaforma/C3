package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.StatoBox;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Classe che gestisce un Locker, dunque la sua posizione geografica (per
 * il momento non reale, ma solo concettualizzata), il numero di Box da cui é composta,
 * una lista degli stessi ed altro ancora.
 */
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="ubicazione")
    private Point locazione;
    @Column(name="numeroBox")
    private int numeroBox;
    @Column(name="citta")
    private String citta;

    private Accensione statoAccensioneLocker;
    /** Lista dei box che sono contenuti nel Locker */
    private ArrayList<Box> listaBox;

    public Locker() {
    }

    public Locker(int longitudine, int latitudine, int numeroBox, String citta) {
        this.locazione = new Point(longitudine, latitudine);
        this.numeroBox = numeroBox;
        this.citta = citta;
        this.statoAccensioneLocker = Accensione.Acceso;
        this.listaBox = new ArrayList<>();
    }

    public void turnOnLocker(){
        this.statoAccensioneLocker= Accensione.Acceso;
    }
    public void turnOffLocker(){
        this.statoAccensioneLocker= Accensione.Spento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getLocazione() { return this.locazione;}

    public void setLocazione(int x, int y) { this.locazione = new Point(x,y); }

    public void setStatoAccensioneLocker(Accensione statoAccensioneLocker) {
        this.statoAccensioneLocker = statoAccensioneLocker;
    }

    public void setNumeroBox(int numeroBox) {
        this.numeroBox = numeroBox;
    }
    public Long getId() {
        return this.id;
    }
    public int getNumeroBox() {
        return this.numeroBox;
    }
    public ArrayList<Box> getAllBoxes() {
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
        return getId().equals(locker.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + id +
                ", longitudine=" + this.locazione.x +
                ", latitudine=" + this.locazione.y +
                ", numeroBox=" + numeroBox +
                '}';
    }

    public String getCitta() {
        return this.citta;
    }
}