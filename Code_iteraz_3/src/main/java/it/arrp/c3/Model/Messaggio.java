package it.arrp.c3.Model;

import javax.persistence.*;

/**
 * Classe che si occupa di gestire un messaggio da parte di un utente (come un Tecnico)
 * verso una seconda persona (ad esempio un Admin).
 */
@Entity
@Table(name = "messaggio")
public class Messaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMessaggio")
    private Long idMessaggio;
    @Column(name = "idMittente")
    private Long idMittente;
    @Column(name = "idDestinatario")
    private Long idDestinatario;
    @Column(name = "messaggio")
    private String messaggio;

    public Messaggio() {
    }

    public Messaggio(Long idMittente, Long idDestinatario, String messaggio) {
        // automatico this.idMessaggio = idMessaggio;
        this.idMittente = idMittente;
        this.idDestinatario = idDestinatario;
        this.messaggio = messaggio;
    }

    public Long getIdMessaggio() {
        return idMessaggio;
    }

    public void setIdMessaggio(Long idMessaggio) {
        this.idMessaggio = idMessaggio;
    }

    public Long getIdMittente() {
        return idMittente;
    }

    public void setIdMittente(Long idMittente) {
        this.idMittente = idMittente;
    }

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Long idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "Messaggio{" +
                "idMessaggio=" + idMessaggio +
                ", uuidFrom=" + idMittente +
                ", uuidTo=" + idDestinatario +
                ", messaggio='" + messaggio + '\'' +
                '}';
    }
}
