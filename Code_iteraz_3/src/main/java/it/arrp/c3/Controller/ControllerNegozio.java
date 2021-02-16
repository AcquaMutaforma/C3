package it.arrp.c3.Controller;

import it.arrp.c3.Service.ServiceNegozio;

import java.util.UUID;

/**
 * Classe che si occupa di gestire le operazioni riguardanti il Ruolo Negozio.
 */
public class ControllerNegozio {
    ServiceNegozio serviceNegozio= new ServiceNegozio();

    public void  creaCorsa(UUID uuidCliente, UUID uuidNegozio){
        serviceNegozio.creaCorsa(uuidCliente,uuidNegozio);
    }
}
