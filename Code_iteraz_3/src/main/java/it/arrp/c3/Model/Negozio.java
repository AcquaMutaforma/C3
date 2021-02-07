package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereNegozio;

import java.util.UUID;

public class Negozio extends UtenteRegistrato {
    public GenereNegozio genereNegozio;

    Negozio(UUID uuid, String nome, String email, String password, String citta, GenereNegozio genereNegozio) {
        setUuid(uuid);
        setNome(nome);
        setEmail(email);
        setPassword(password);
        setCitta(citta);
        setGenereNegozio(genereNegozio);
    }

    public GenereNegozio getGenereNegozio() {
        return genereNegozio;
    }

    public void setGenereNegozio(GenereNegozio genereNegozio) {
        this.genereNegozio = genereNegozio;
    }

}
