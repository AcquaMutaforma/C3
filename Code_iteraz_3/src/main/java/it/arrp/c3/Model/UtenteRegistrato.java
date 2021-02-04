package it.arrp.c3.Model;

import it.arrp.c3.Utenti.UtenteInterface;

import java.util.UUID;

public class UtenteRegistrato implements UtenteInterface {
    public UUID uuid;
    public String nome;
    public String email;
    public String password;
    public String citta;

    @Override
    public UUID getID (){
        return this.uuid;
    }
    @Override
    public String getNome(){
        return this.nome;
    }
    @Override
    public String getEmail() {
        return this.email;
    }
    @Override
    public boolean setId(UUID i) {
        return false;
    }
    @Override
    public boolean setNome(String n) {
        return false;
    }
    @Override
    public boolean setEmail(String s) {
        return false;
    }
    public String getPassword() {
        return this.password;
    }
    public String getCitta() {
        return this.citta;
    }
}
