package it.arrp.c3.Model;

import javax.persistence.*;

/**
 * Classe che si occupa di gestire un Pacco da consegnare, andando ad ottenere i vari
 * codici identificativi per individuare il pacco stesso, il mittente
 * ed il destinatario ultimo.
 */
@Entity
public class Pacco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPacco")
    private Long idPacco;
    @Column(name = "idNegozio")
    private Long idNegozio;
    @Column(name = "idCliente")
    private Long idCliente;

    public Pacco() {
    }

    public Pacco(Long idCommerciante, Long idCliente) {
        setIdCliente(idCliente);
        setIdNegozio(idCommerciante);
    }

    public Long getIdNegozio() {
        return idNegozio;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdPacco() {
        return idPacco;
    }

    public void setIdNegozio(Long idNegozio) {
        this.idNegozio = idNegozio;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdPacco(Long idPacco) {
        this.idPacco = idPacco;
    }

    @Override
    public String toString() {
        return "Pacco{" +
                "idPacco=" + getIdPacco() +
                ", idCommerciante=" + getIdNegozio() +
                ", idCliente=" + getIdCliente() +
                '}';
    }
}
