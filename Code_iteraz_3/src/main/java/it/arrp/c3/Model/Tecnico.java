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
    private String cittaDiLavoro; //Todo: da aggiungere, ci eravamo dimenticati.
    //TODO forse conviene inserire le richieste nelle notifiche ? cosi non ci sono due liste che fanno la medesima cosa,
    // ne parliamo poi decidiamo -A
    Locker lockerAttivo; //TODO da aggiungere metodi di "locking" di un locker ad un tecnico (anche nel vpp) --Ric

    public Tecnico(Long idCliente) {
        super(idCliente);
    }

    public Tecnico(Long idCliente, Admin admin) {
        super(idCliente);
        this.admin = admin;
        this.listaRichieste = new ArrayList<>();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public void addRichiesta(Messaggio m){ this.listaRichieste.add(m); }
    public boolean rimuoviRichiesta(Messaggio m){ return this.listaRichieste.remove(m); }
    public Locker getLockerAttivo() {
        return lockerAttivo;
    }

    public String getCittaDiLavoro() {
        return cittaDiLavoro;
    }

    public void setCittaDiLavoro(String cittaDiLavoro) {
        this.cittaDiLavoro = cittaDiLavoro;
    }

    public void setLockerAttivo(Locker lockerAttivo) {
        this.lockerAttivo = lockerAttivo;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "idCLiente=" + idCLiente +
                ", admin=" + this.admin.idCLiente +
                '}';
    }
}
