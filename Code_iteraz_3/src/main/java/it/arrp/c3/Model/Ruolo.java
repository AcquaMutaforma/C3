package it.arrp.c3.Model;

/**
 * Questa classe si occupa di gestire i vari ruoli che un Cliente puo' avere.
 */
public class Ruolo {
    Long idCLiente;
    String nomeRuolo;

    public Ruolo(Long idCliente, String nomeRuolo) {
        this.idCLiente = idCliente;
        this.nomeRuolo = nomeRuolo;
    }
}
