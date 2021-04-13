package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.StatoBox;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Questa classe ha la responsabilità di gestire un singolo Box facente parte di
 * un Locker. Ne consegue che gestirà il proprio stato, la chiave di apertura
 * e, per questa implementazione, anche la sua apertura/chiusura simulata.
 */
@Entity
public class Box{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idBox;
    private Long idCliente;
    private Locker locker;
    private boolean chiuso; //TODO potrebb essere un enum, da valutare --ale
    private StatoBox stato;
    private Accensione statoAccensioneBox =Accensione.Acceso;

    public Box() {
    }

    public Box(Long id, Locker l) {
        this.idBox = id;
        this.idCliente = null;
        this.chiuso = true;
        this.stato = StatoBox.Libero;
        this.locker = l;
    }

    public void turnOnBox(){
        this.statoAccensioneBox= Accensione.Acceso;
    }
    public void turnOffBox(){
        this.statoAccensioneBox= Accensione.Spento;
    }


    public Long getIdBox() {
        return this.idBox;
    }

    public StatoBox getStato() {
        return this.stato;
    }

    public boolean isChiuso() {
        return this.chiuso;
    }

    /**
     * cambia stato, attesa --> occupato --> libero
     */
    public void avanzaStato() {
        switch (stato){
            case Libero: this.stato = StatoBox.Attesa;
            case Attesa: this.stato = StatoBox.Occupato;
            case Occupato: this.stato = StatoBox.Libero;
        }
    }

    public void unlock() {
        this.chiuso = false;
    }

    public void lock() {
        this.chiuso = true;
    }

    public void setStato(StatoBox s) {
        this.stato = s;
    }

    public void setIdBox(Long idBox) {
        this.idBox = idBox;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public void setChiuso(boolean chiuso) {
        this.chiuso = chiuso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return getIdBox().equals(box.getIdBox());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBox());
    }

    @Override
    public String toString() {
        return "Box{" +
                "idBox=" + idBox +
                ", cliente=" + idCliente +
                ", locker=" + locker +
                ", chiuso=" + chiuso +
                ", stato=" + stato +
                '}';
    }
}