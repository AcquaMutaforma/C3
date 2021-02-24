package it.arrp.c3.Controller;

import it.arrp.c3.Service.ServiceNegozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Classe che si occupa di gestire le operazioni riguardanti il Ruolo Commerciante.
 */
@RestController
public class ControllerCommerciante {
    @Autowired
    ServiceNegozio serviceNegozio;

    public void  creaCorsa(Long uuidCliente, Long uuidNegozio){
        //TODO da finire
        serviceNegozio.creaCorsa(uuidCliente,uuidNegozio);
    }

    //TODO
}
