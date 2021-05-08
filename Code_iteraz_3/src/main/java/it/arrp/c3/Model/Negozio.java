package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Enum.GenereProdotto;

import javax.persistence.Column;
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

    @Column(name="nomeNegozio")
    private String nomeNegozio;
    @Column(name="cittaNegozio")
    private String cittaNegozio;
    @Column(name="genereNegozio")
    private GenereNegozio genereNegozio;
    private List<Prodotto> listaProdottiInEvidenza;
    private List<Corriere> listaCorrieriAssunti;

    public Negozio(Long idCliente) {
        super(idCliente);
    }

    public Negozio(Long idCliente, String nomeNegozio, String cittaNegozio, GenereNegozio genereNegozio) {
        super(idCliente);
        this.nomeNegozio = nomeNegozio;
        this.cittaNegozio = cittaNegozio;
        this.genereNegozio = genereNegozio;
        this.listaCorrieriAssunti = new ArrayList<>();
        this.listaProdottiInEvidenza = new ArrayList<>();
    }

    //non puo essere null, lo controlla service negozio
    public boolean aggiungiProdotto(Prodotto p){
        //Todo da mettere un numero massimo di prodotti in evidenza
        this.listaProdottiInEvidenza.add(p);
        return true;
    }

    //non puo essere null, lo controlla service negozio
    public boolean rimuoviProdotto(Prodotto p){
        return this.listaProdottiInEvidenza.remove(p);
    }

    public List<Corriere> getListaCorrieriAssunti() {
        return listaCorrieriAssunti;
    }

    public void setListaCorrieriAssunti(ArrayList<Corriere> listaCorrieriAssunti) {
        this.listaCorrieriAssunti = listaCorrieriAssunti;
    }

    public void addCorriere(Corriere corriere){
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

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public void setNomeNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
    }

    @Override
    public String toString() {
        return "Negozio{" +
                "nomeNegozio='" + nomeNegozio + '\'' +
                ", cittaNegozio='" + cittaNegozio + '\'' +
                ", genereNegozio=" + genereNegozio +
                ", idCLiente=" + idCLiente +
                '}';
    }

}
