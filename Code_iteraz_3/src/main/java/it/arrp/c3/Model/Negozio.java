package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereNegozio;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Questa classe rappresenta il ruolo di un utente, ovvero un Negozio.
 * Questo ruolo consente di gestire un negozio, con le varie funzionalità che ne
 * derivano, come creare delle corse, assumere un corriere e pubblicizzare un
 * prodotto che si ha in negozio.
 */
@Entity
public class Negozio extends Ruolo {

    //TODO rimuovere Locazione geografica dagli schemi, non abbiamo tempo

    private String cittaNegozio;
    private GenereNegozio genereNegozio;
    private List<Prodotto> listaProdottiInEvidenza;
    private ArrayList<Corriere> listaCorrieriAssunti;

    public Negozio(Long idCliente/*, String nomeRuolo*/) {
        super(idCliente/*, nomeRuolo*/);
    }

    public Negozio(Long idCliente/*, String nomeRuolo*/, String cittaNegozio, GenereNegozio genereNegozio) {
        super(idCliente/*, nomeRuolo*/);
        this.cittaNegozio = cittaNegozio;
        this.genereNegozio = genereNegozio;
        this.listaCorrieriAssunti = new ArrayList<>();
        this.listaProdottiInEvidenza = new ArrayList<>();
    }

    public ArrayList<Corriere> getListaCorrieriAssunti() {
        return listaCorrieriAssunti;
    }

    public void setListaCorrieriAssunti(ArrayList<Corriere> listaCorrieriAssunti) {
        this.listaCorrieriAssunti = listaCorrieriAssunti;
    }

    public void assumiCorriere(Corriere corriere){
        listaCorrieriAssunti.add(corriere);
    }

    public GenereNegozio getGenereNegozio() {
        return genereNegozio;
    }

    public void setGenereNegozio(GenereNegozio genereNegozio) {
        this.genereNegozio = genereNegozio;
    }

    public String getCittaNegozio() {
        return cittaNegozio;
    }

    public void setCittaNegozio(String cittaNegozio) {
        this.cittaNegozio = cittaNegozio;
    }

    public List<Prodotto> getListaProdottiInEvidenza() {
        return listaProdottiInEvidenza;
    }

    @Override
    public String toString() {
        return "Negozio{" +
                "cittaNegozio='" + cittaNegozio + '\'' +
                ", genereNegozio=" + genereNegozio +
                ", idCLiente=" + idCLiente +
                '}';
    }
}
