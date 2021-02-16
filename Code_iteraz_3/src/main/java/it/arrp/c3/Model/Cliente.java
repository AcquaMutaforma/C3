package it.arrp.c3.Model;

import sun.security.util.Password;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Questa classe rappresenta un Cliente, ovvero un utente registrato, il quale
 * puo' effettuare ricerche, richiedere che gli sia consegnato un pacco in un determinato
 * Locker ed altro.
 */
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private Long idCliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private Password password;
    @Column(name = "residenza")
    private String citta;
    private List<Messaggio> notifiche;
    private List<String> listaRuoli;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, Password password, String citta) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setPassword(password);
        this.citta = citta;
        this.listaRuoli = new ArrayList<String>();
        this.notifiche = new ArrayList<Messaggio>();
    }

    public void setPassword(Password password) {
        this.password = password;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public Long getID (){
        return this.idCliente;
    }
    public void setId(Long id){ this.idCliente = id;}
    public String getNome(){
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public boolean setUuid(UUID i) {
        return false;
    }
    public boolean setNome(String n) {
        return false;
    }
    public boolean setEmail(String s) {
        return false;
    }
    public Password getPassword() {
        return this.password;
    }
    public String getCitta() {
        return this.citta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", citta='" + citta + '\'' +
                '}';
    }
}
