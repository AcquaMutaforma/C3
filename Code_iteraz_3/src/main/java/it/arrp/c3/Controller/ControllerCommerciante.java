package it.arrp.c3.Controller;

import it.arrp.c3.Service.ServiceNegozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe che si occupa di gestire le operazioni riguardanti il Ruolo Commerciante.
 */
@RestController
public class ControllerCommerciante {
    @Autowired
    ServiceNegozio serviceNegozio;

    public void  creaCorsa(Long uuidCliente, Long uuidNegozio){
        //TODO da finire
        if (serviceNegozio.creaCorsa(uuidCliente,uuidNegozio)){
            //stampa qualcosa, è andato tutto bene
        }
        else{
            //c'è stato un errore
        }
    }

    //TODO
}
