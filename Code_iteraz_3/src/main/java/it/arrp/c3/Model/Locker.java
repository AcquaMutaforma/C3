package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.StatoBox;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;

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
    private int longitudine;
    private int latitudine;
    private int numeroBox;
    private Accensione statoAccensioneLocker = Accensione.Acceso;
    /** Lista dei box che sono contenuti nel Locker */
    private ArrayList<Box> listaBox;

    public Locker() {
    }

    public Locker(int longitudine, int latitudine, int numeroBox) {
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.numeroBox = numeroBox;
        this.listaBox = new ArrayList<>();
    }

    public void turnOnLocker(){
        this.statoAccensioneLocker= Accensione.Acceso;
    }
    public void turnOffLocker(){
        this.statoAccensioneLocker= Accensione.Spento;
    }

    /**
     * Metodo assegnazione Box del locker ad un cliente.
     * @param idCliente .
     * @return false = nessun box disponibile / true = box assegnato al cliente
     */
    public boolean assegnaBox(Long idCliente) {
        //TODO
        return false;
    }

    public Box getBoxById(Long idbox) {
        Iterator<Box> iter = listaBox.iterator();
        Box b;
        while (iter.hasNext()){
            b = iter.next();
            if(b.getIdBox().equals(idbox))
                return b;
        }
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getLongitudine() {
        return longitudine;
    }
    public void setLongitudine(int longitudine) {
        this.longitudine = longitudine;
    }
    public int getLatitudine() {
        return latitudine;
    }
    public void setLatitudine(int latitudine) {
        this.latitudine = latitudine;
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

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + id +
                ", longitudine=" + longitudine +
                ", latitudine=" + latitudine +
                ", numeroBox=" + numeroBox +
                '}';
    }
}