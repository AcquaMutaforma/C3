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

    public static final int max_box = 10;
    public static final int max_notifiche = 20;

    //TODO bisogna creare dei controlli per dei limiti altrimenti le notifiche arrivano a infinito come i box o i ruoli

    public Cliente() {
    }

    public Cliente(String nome, String email, String password, String citta) {
        //TODO test se funziona senza setId();
        setNome(nome);
        setEmail(email);
        setPassword(password);
        setCitta(citta);
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
    public void setNome(String n) {
        this.nome=n;
    }
    public void setEmail(String s) {
        this.email=s;
    }
    public void setId(Long id){ this.idCliente = id;}
    public void setCheckpoint(Locker checkpoint) {
        this.checkpoint = checkpoint;
    }
    public Long getID (){
        return this.idCliente;
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
        if(!this.boxAssegnati.contains(boxAssegnato) && this.boxAssegnati.size() <= max_box)
            this.boxAssegnati.add(boxAssegnato);
    }

    public void aggiungiRuolo(TipoRuolo ruolo) {
        if(!this.listaRuoli.contains(ruolo))
            this.listaRuoli.add(ruolo);
    }

    public void rimuoviRuolo(TipoRuolo tipoRuolo){
        this.listaRuoli.remove(tipoRuolo);
    }

    public void aggiungiNotifica(Messaggio m){
        if(m!=null && notifiche.size() <= max_notifiche)
            this.notifiche.add(m);
    }

    public void removeBox(Long idBox) {
        this.boxAssegnati.removeIf(x -> x.getIdBox().equals(idBox));
    }
}
