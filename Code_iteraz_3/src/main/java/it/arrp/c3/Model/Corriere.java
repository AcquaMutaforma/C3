package it.arrp.c3.Model;

import javax.persistence.Entity;
import java.util.ArrayList;

/**
 * Questa classe rappresenta il ruolo di un utente, ossia il Corriere.
 * Con questo ruolo si possono effettuare consegne ai vari locker per conto
 * dei vari negozi per cui si é registrati.
 */
@Entity
public class Corriere extends Ruolo {

    private String mezzoDiTrasporto;
    private ArrayList<Negozio> listaNegoziCollegati;

    public Corriere(Long idCliente, String nomeRuolo) {
        super(idCliente, nomeRuolo);
    }

    public Corriere(Long uuidCliente, String nomeRuolo, String mezzoDiTrasporto) {
        super(uuidCliente, nomeRuolo);
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
                "mezzoDiTrasporto='" + mezzoDiTrasporto + '\'' +
                ", idCLiente=" + idCLiente +
                ", nomeRuolo='" + nomeRuolo + '\'' +
                '}';
    }
}
