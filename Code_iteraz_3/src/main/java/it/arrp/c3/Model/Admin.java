package it.arrp.c3.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta il ruolo di un utente
 * che puo' essere l'amministratore di sistema. Costui potra' poi aggiungere dei Tecnici
 * ed operare in vari campi della manutenzione.
 */
@Entity(name = "User")
@Table(name = "users")
@DiscriminatorValue("1")
public class Admin extends Ruolo{

    @Column(name="luogoLavorativo")
    private String cittaDiLavoro;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tecnico> listaTecnici;

    public Admin(Long idCliente) {
        super(idCliente);
    }

    public Admin(Long idCliente, String cittaDiLavoro) {
        super(idCliente);
        this.cittaDiLavoro = cittaDiLavoro;
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
                "cittaDiLavoro='" + cittaDiLavoro + '\'' +
                ", idCLiente=" + idCLiente +
                '}';
    }

    public List<Tecnico> getListaTecnici(){ return this.listaTecnici; }
    public void addTecnico(Tecnico tec){ this.listaTecnici.add(tec); }
    public boolean removeTecnico(Tecnico tec){ return this.listaTecnici.remove(tec);}
}
