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
    private Long uuidFrom, uuidTo;
    private String messaggio;

    public Messaggio() {
    }

    public Messaggio(Long uuidFrom, Long uuidTo, String messaggio) {
        // automatico this.idMessaggio = idMessaggio;
        this.uuidFrom = uuidFrom;
        this.uuidTo = uuidTo;
        this.messaggio = messaggio;
    }

    public Long getIdMessaggio() {
        return idMessaggio;
    }

    public void setIdMessaggio(Long idMessaggio) {
        this.idMessaggio = idMessaggio;
    }

    public Long getUuidFrom() {
        return uuidFrom;
    }

    public void setUuidFrom(Long uuidFrom) {
        this.uuidFrom = uuidFrom;
    }

    public Long getUuidTo() {
        return uuidTo;
    }

    public void setUuidTo(Long uuidTo) {
        this.uuidTo = uuidTo;
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
                ", uuidFrom=" + uuidFrom +
                ", uuidTo=" + uuidTo +
                ", messaggio='" + messaggio + '\'' +
                '}';
    }
}
