package it.arrp.c3.Model;

/**
 * Questa classe si occupa di gestire i vari ruoli che un Cliente puo' avere.
 */
public class Ruolo {
    //TODO Da valutare se mettere tutte le aggiunte di vari ruoli ad un cliente quì anziché averle sparse. --Ric
    Long idCLiente;
    //String nomeRuolo;

    public Ruolo(Long idCliente /*, String nomeRuolo*/) {
        this.idCLiente = idCliente;
        //this.nomeRuolo = nomeRuolo;
    }

    public Long getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Long idCLiente) {
        this.idCLiente = idCLiente;
    }
/*
    public String getNomeRuolo() {
        return nomeRuolo;
    }

    public void setNomeRuolo(String nomeRuolo) {
        this.nomeRuolo = nomeRuolo;
    }

 */
}
