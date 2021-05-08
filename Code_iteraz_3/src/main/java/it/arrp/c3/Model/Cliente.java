package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.TipoRuolo;

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
    /*
    * @SequenceGenerator(
    *       name="sequenza_clienti",
    *       sequenceName="sequenza_clienti",
    *       initialValue = 0,
    *       allocationSize=1 //incremento ad ogni generazione
    * )
    *@GeneratedValue(
    *       strategy = SEQUENCE,
    *       generator = "sequenza_clienti")
    *@Column(
    *       name = "codice_identificativo_cliente", //tradotto: il nome della colonna puó essere custom
    *       updatable=false,
    *       nullable=false, //giusto per averlo quí, il valore generato non sarebbe mai nullo, quindi np here
    *       columnDefinition = "LONG", //definisce il tipo di valore nella colonna, a mó di SQL, quindi non sono certo di quel valore, ma si imposta cosí.
    *       //sul video che ho visto, la columnDefinition non la scrive su id e viene automatico "bigint".
    *       unique=true, //il valore é unico in tutta la tabella... stessa cosa di nullable penso (inutile quí ma utile altrove)
    *
    *       )
     * */
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
    private List<TipoRuolo> listaRuoli;
    private List<Box> boxAssegnati;

    //TODO bisogna creare dei controlli per dei limiti altrimenti le notifiche arrivano a infinito come i box o i ruoli

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
    public List<TipoRuolo> getListaRuoli() {
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

    public void aggiungiRuolo(TipoRuolo ruolo) {
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
