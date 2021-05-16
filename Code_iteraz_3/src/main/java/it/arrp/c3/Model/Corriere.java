package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.StatoCorriere;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta il ruolo di un utente, ossia il Corriere.
 * Con questo ruolo si possono effettuare consegne ai vari locker per conto
 * dei vari negozi per cui si é registrati.
 */
@Entity(name = "Corriere")
@Table(name = "corriere")
@DiscriminatorValue("1")
public class Corriere extends Ruolo {

    @Enumerated(EnumType.STRING)
    private StatoCorriere stato;
    @Column(name="mezzoDiTrasporto")
    private String mezzoDiTrasporto;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Negozio> listaNegoziCollegati;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Corsa> listaCorse;
    //TODO extra: forse potrebbe essere comodo inserire una lista di corse completate o un contatore, e' superfluo -A

    public Corriere(Long idCliente) {
        super(idCliente);
    }

    public Corriere() {
        super(null);
    }

    public Corriere(Long idCliente, String mezzoDiTrasporto) {
        super(idCliente);

        this.stato = StatoCorriere.NonAttivo;
        this.listaCorse = new ArrayList<>();
        this.mezzoDiTrasporto = mezzoDiTrasporto;
        this.listaNegoziCollegati = new ArrayList<>();        System.out.println("costruisco.......~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public boolean rimuoviNegozio(Long idCorriere, Negozio negozio) {
        return this.listaNegoziCollegati.remove(negozio);
    }

    public void addNuovaCorsa(Corsa corsa){ listaCorse.add(corsa);   }

    public void addNegozio(Negozio neg){
        this.listaNegoziCollegati.add(neg);
    }

    public String getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }
    public void setMezzoDiTrasporto(String mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }
    public List<Negozio> getListaNegoziCollegati() {
        return listaNegoziCollegati;
    }

    @Override
    public String toString() {
        return "Corriere{" +
                "stato=" + stato +
                ", mezzoDiTrasporto='" + mezzoDiTrasporto + '\'' +
                ", idCLiente=" + idCliente +
                '}';
    }

    public List<Corsa> getAllCorse() {
        return this.listaCorse;
    }

    public Corsa getCorsa(Long idCorsa){
        for(Corsa c : this.listaCorse){
            if(c.getIdCorsa().equals(idCorsa))
                return c;
        }
        return null;
    }

    public void setStato(StatoCorriere statoCorriere) {
        this.stato = statoCorriere;
    }
    public StatoCorriere getStato() {return stato;   }

    public void rimuoviCorsa(Corsa corsa) {
        this.listaCorse.remove(corsa);
    }

}
