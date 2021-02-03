package it.arrp.c3.Model;

import java.util.UUID;

public class UtenteRegistrato {
    public UUID uuid;
    public String nome;
    public String email;
    public String password;
    public String citta;

    public UUID getId (){
        return this.uuid;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCitta() {
        return this.citta;
    }
}
