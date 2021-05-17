package it.arrp.c3.Model;

import javax.persistence.*;

/**
 * Questa classe rappresenta il ruolo di un utente, in questo caso, un Tecnico.
 * Costui potrà operare in diversi ambiti della manutenzione, ma non potrà,
 * tra le altre cose, aggiungere altri tecnici o amministratori di sistema.
 */
@Entity(name = "Tecnico")
@Table(name = "tecnico")
@DiscriminatorValue("1")
public class Tecnico extends Ruolo{

    @OneToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @Column(name="luogoDiLavoro")
    private String cittaDiLavoro; //Todo: da aggiungere, ci eravamo dimenticati.
    //TODO forse conviene inserire le richieste nelle notifiche ? cosi non ci sono due liste che fanno la medesima cosa,
    // ne parliamo poi decidiamo -A
    @OneToOne(fetch = FetchType.LAZY)
    Locker lockerAttivo; //TODO da aggiungere metodi di "locking" di un locker ad un tecnico (anche nel vpp) --Ric

    public Tecnico(Long idCliente) {
        super(idCliente);
    }

    public Tecnico() {
        super(null);
    }

    public Tecnico(Long idCliente, Admin admin) {
        super(idCliente);
        System.out.println("costruisco....~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.cittaDiLavoro = admin.getCittaDiLavoro();
        this.admin = admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public void setCittaDiLavoro(String cittaDiLavoro) {
        this.cittaDiLavoro = cittaDiLavoro;
    }
    public void setLockerAttivo(Locker lockerAttivo) {
        this.lockerAttivo = lockerAttivo;
    }
    public Admin getAdmin() {
        return admin;
    }
    public String getCittaDiLavoro() {
        return cittaDiLavoro;
    }
    public Locker getLockerAttivo() {
        return lockerAttivo;
    }


    @Override
    public String toString() {
        return "Tecnico{" +
                "idCLiente=" + idCliente +
                ", admin=" + this.admin.idCliente +
                '}';
    }
}
