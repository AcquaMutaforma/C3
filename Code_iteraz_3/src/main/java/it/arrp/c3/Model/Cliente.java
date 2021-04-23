package it.arrp.c3.Model;

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
    @Column(name = "id")
    private Long idCliente;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "residenza")
    private String citta;

    private Locker checkpoint;
    private List<Messaggio> notifiche;
    private List<String> listaRuoli;
    private List<Box> boxAssegnati;
    //TODO forse e' un errore avere la lista con un tipo di oggetto invece che di Long -A

    public Cliente() {
    }

    public Cliente(String nome, String email, String password, String citta) {
        //TODO test se funziona senza setId();
        setNome(nome);
        setEmail(email);
        setPassword(password);
        this.citta = citta;
        this.listaRuoli = new ArrayList<>();
        this.notifiche = new ArrayList<>();
        this.boxAssegnati = new ArrayList<>();
    }

    public void setPassword(String password) {
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
    public String getPassword() {
        return this.password;
    }
    public String getCitta() {
        return this.citta;
    }
    public List<Messaggio> getNotifiche() {
        return notifiche;
    }
    public List<String> getListaRuoli() {
        return listaRuoli;
    }
    public List<Box> getBoxAssegnati() {
        return boxAssegnati;
    }
    public Locker getCheckpoint() {
        return checkpoint;
    }
    public void setCheckpoint(Locker checkpoint) {
        this.checkpoint = checkpoint;
    }
    //mancano i setter delle liste, ma non credo servano a molto -ale
    
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

    public void addBox(Box boxAssegnato) {
        this.boxAssegnati.add(boxAssegnato);
    }

    public void aggiungiRuolo(String ruolo) {
        this.listaRuoli.add(ruolo);
    }

    public void aggiungiNotifica(Messaggio m){
        if(m!=null)
            this.notifiche.add(m);
    }

    public void removeBox(Long idBox) {
        this.boxAssegnati.removeIf(x -> x.getIdBox().equals(idBox));
    }
}
