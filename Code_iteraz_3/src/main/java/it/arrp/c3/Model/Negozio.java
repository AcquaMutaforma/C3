package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereNegozio;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Questa classe rappresenta il ruolo di un utente, ovvero un Negozio.
 * Questo ruolo consente di gestire un negozio, con le varie funzionalità che ne
 * derivano, come creare delle corse, assumere un corriere e pubblicizzare un
 * prodotto che si ha in negozio.
 */
public class Negozio extends Ruolo {
    public GenereNegozio genereNegozio;
    public ArrayList<Corriere> listaCorrieriAssunti;

    Negozio(GenereNegozio genereNegozio) {
        setGenereNegozio(genereNegozio);
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

}
