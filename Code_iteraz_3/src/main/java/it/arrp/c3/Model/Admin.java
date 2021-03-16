package it.arrp.c3.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta il ruolo di un utente
 * che puo' essere l'amministratore di sistema. Costui potra' poi aggiungere dei Tecnici
 * ed operare in vari campi della manutenzione.
 */
@Entity
public class Admin extends Ruolo{

    private String cittaDiLavoro;
    private List<Tecnico> listaTecnici;
    private List<Messaggio> listaRichieste;

    public Admin(Long idCliente/*, String nomeRuolo*/) {
        super(idCliente/*, nomeRuolo*/);
    }

    public Admin(Long idCliente/*, String nomeRuolo*/, String cittaDiLavoro) {
        super(idCliente/*, nomeRuolo*/);
        this.cittaDiLavoro = cittaDiLavoro;
        this.listaRichieste = new ArrayList<>();
        this.listaTecnici = new ArrayList<>();
    }

    public String getCittaDiLavoro() {
        return cittaDiLavoro;
    }

    public void setCittaDiLavoro(String cittaDiLavoro) {
        this.cittaDiLavoro = cittaDiLavoro;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idCLiente=" + idCLiente +
                /*", nomeRuolo='" + nomeRuolo + */'\'' +
                '}';
    }

    public void addTicket(Messaggio m) {
        this.listaRichieste.add(m);
    }

    public boolean rmRichiesta(Messaggio m){
        return listaRichieste.remove(m);
    }
}
