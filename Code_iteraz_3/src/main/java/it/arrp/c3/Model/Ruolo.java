package it.arrp.c3.Model;

import javax.persistence.*;

/**
 * Questa classe si occupa di rappresentare i vari ruoli che un Cliente puo' avere.
 */
@Entity(name = "AbstractUser")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "abstract_user")
public abstract class Ruolo {
    @Id
    @Column(name="idCliente")
    Long idCliente;

    public Ruolo(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
