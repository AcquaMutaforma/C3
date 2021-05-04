package it.arrp.c3.Model;

/**
 * Questa classe si occupa di rappresentare i vari ruoli che un Cliente puo' avere.
 */
public class Ruolo {
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
