package it.arrp.c3.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta il ruolo di un utente, in questo caso, un Tecnico.
 * Costui potrà operare in diversi ambiti della manutenzione, ma non potrà,
 * tra le altre cose, aggiungere altri tecnici o amministratori di sistema.
 */
@Entity
public class Tecnico extends Ruolo{

    private Admin admin;
    private List<Messaggio> listaRichieste;

    public Tecnico(Long idCliente, String nomeRuolo) {
        super(idCliente, nomeRuolo);
    }

    public Tecnico(Long idCliente, String nomeRuolo, Admin admin) {
        super(idCliente, nomeRuolo);
        this.admin = admin;
        this.listaRichieste = new ArrayList<>();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    //TODO add / remove richiesta


    @Override
    public String toString() {
        return "Tecnico{" +
                "idCLiente=" + idCLiente +
                ", nomeRuolo='" + nomeRuolo + '\'' +
                ", admin=" + this.admin.idCLiente +
                '}';
    }
}
