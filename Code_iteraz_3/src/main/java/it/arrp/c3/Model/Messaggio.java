package it.arrp.c3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe che si occupa di gestire un messaggio da parte di un utente (come un Tecnico)
 * verso una seconda persona (ad esempio un Admin).
 */
@Entity
public class Messaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMessaggio;
    private Long idMittente, idDestinatario;
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
