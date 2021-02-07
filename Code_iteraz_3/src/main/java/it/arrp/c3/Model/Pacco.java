package it.arrp.c3.Model;

import java.util.UUID;

public class Pacco {

    UUID idCommerciante, idCliente, idPacco;

    public Pacco(UUID idPacco, UUID idCommerciante, UUID idCliente) {
        this.idPacco = idPacco;
        setIdCliente(idCliente);
        setIdCommerciante(idCommerciante);
    }

    public UUID getIdCommerciante() {
        return idCommerciante;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public UUID getIdPacco() {
        return idPacco;
    }

    public void setIdCommerciante(UUID idCommerciante) {
        this.idCommerciante = idCommerciante;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
}
