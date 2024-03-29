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

    @Column(name = "Admin" )
    private Long idAdmin;

    @Column(name="luogoDiLavoro")
    private String cittaDiLavoro;
    @OneToOne(fetch = FetchType.EAGER)
    private Locker lockerAttivo;
    //TODO da aggiungere metodi di "locking" di un locker ad un tecnico (anche nel vpp) --Ric

    public Tecnico(Long idCliente) {
        super(idCliente);
    }

    public Tecnico() {
        super(null);
    }

    public Tecnico(Long idCliente, Long idAdmin, String cittaDiLavoro ) {
        super(idCliente);
        this.cittaDiLavoro = cittaDiLavoro;
        this.idAdmin = idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }
    public void setCittaDiLavoro(String cittaDiLavoro) {
        this.cittaDiLavoro = cittaDiLavoro;
    }
    public void setLockerAttivo(Locker lockerAttivo) {
        this.lockerAttivo = lockerAttivo;
    }
    public Long getIdAdmin() {
        return idAdmin;
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
                ", admin=" + this.idAdmin +
                '}';
    }
}
