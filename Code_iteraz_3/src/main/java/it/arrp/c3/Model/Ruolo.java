package it.arrp.c3.Model;

/**
 * Questa classe si occupa di gestire i vari ruoli che un Cliente puo' avere.
 */
public class Ruolo {
    //TODO Da valutare se mettere tutte le aggiunte di vari ruoli ad un cliente quì anziché averle sparse. --Ric
    //il cliente ha una variabile lista di ruoli che possiede --a
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
