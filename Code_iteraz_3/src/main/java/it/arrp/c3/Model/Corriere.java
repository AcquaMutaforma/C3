package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.StatoCorriere;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta il ruolo di un utente, ossia il Corriere.
 * Con questo ruolo si possono effettuare consegne ai vari locker per conto
 * dei vari negozi per cui si é registrati.
 */
@Entity
public class Corriere extends Ruolo {

    private StatoCorriere stato;
    private String mezzoDiTrasporto;
    private ArrayList<Negozio> listaNegoziCollegati;
    private ArrayList<Corsa> listaCorse;

    public Corriere(Long idCliente) {
        super(idCliente);
    }

    public Corriere(Long uuidCliente, String mezzoDiTrasporto) {
        super(uuidCliente);
        this.stato = StatoCorriere.NonAttivo;
        this.listaCorse = new ArrayList<>();
        this.mezzoDiTrasporto = mezzoDiTrasporto;
        this.listaNegoziCollegati = new ArrayList<>();
    }

    public boolean rimuoviNegozio(Long idNegozio) {
        //TODO da implementare.
        return true;
    }

    public void addNegozio(Long idNegozio){
        //TODO
    }

    public String getMezzoDiTrasporto() {
        return mezzoDiTrasporto;
    }
    public void setMezzoDiTrasporto(String mezzoDiTrasporto) {
        this.mezzoDiTrasporto = mezzoDiTrasporto;
    }
    public ArrayList<Negozio> getListaNegoziCollegati() {
        return listaNegoziCollegati;
    }

    @Override
    public String toString() {
        return "Corriere{" +
                "stato=" + stato +
                ", mezzoDiTrasporto='" + mezzoDiTrasporto + '\'' +
                ", idCLiente=" + idCLiente +
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

    public void rimuoviCorsa(Long idCorsa) {
        this.listaCorse.remove(getCorsa(idCorsa));
    }
}
