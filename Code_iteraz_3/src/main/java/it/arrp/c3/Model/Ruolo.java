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
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idCLiente;

    public Ruolo(Long idCliente) {
        this.idCLiente = idCliente;
    }

    public Long getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Long idCLiente) {
        this.idCLiente = idCLiente;
    }

}
