package it.arrp.c3.Controller;

import it.arrp.c3.Service.ServiceNegozio;

import java.util.UUID;

public class ControllerNegozio {
    ServiceNegozio serviceNegozio= new ServiceNegozio();

    public void  creaCorsa(UUID uuidCliente, UUID uuidNegozio){
        serviceNegozio.creaCorsa(uuidCliente,uuidNegozio);
    }
}
