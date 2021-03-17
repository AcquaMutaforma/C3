package it.arrp.c3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe che si occupa di gestire un Pacco da consegnare, andando ad ottenere i vari
 * codici identificativi per individuare il pacco stesso, il mittente
 * ed il destinatario ultimo.
 */
@Entity
public class Pacco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacco;

    private Long idCommerciante, idCliente;

    public Pacco() {
    }

    public Pacco(/*Long idPacco, */Long idCommerciante, Long idCliente) {
        /*this.idPacco = idPacco;*/
        //TODO controllare che vada bene generare il codice pacco dalle annotazioni sopra alla dichiarazione di idPacco. --Ric
        setIdCliente(idCliente);
        setIdCommerciante(idCommerciante);
    }

    public Long getIdCommerciante() {
        return idCommerciante;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdPacco() {
        return idPacco;
    }

    public void setIdCommerciante(Long idCommerciante) {
        this.idCommerciante = idCommerciante;
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
                ", idCommerciante=" + getIdCommerciante() +
                ", idCliente=" + getIdCliente() +
                '}';
    }
}
