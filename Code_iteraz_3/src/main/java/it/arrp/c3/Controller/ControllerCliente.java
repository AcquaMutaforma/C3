package it.arrp.c3.Controller;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerCliente{
    @Autowired
    ServiceCliente servClie;

    //TODO
    /* Probabilmente il controller deve "salvare" il suo cliente, poi nelle funzioni si usa this.cliente.getId()
    *  Forse si potrebbe usare una funzione chiamata "login" o simili */

    @PostMapping("/cliente/{idCliente}/checkpoint")
    public boolean setCheckpoint(@PathVariable Long idCliente, @RequestParam Long idLocker){
        return servClie.setCheckpoint(idCliente, idLocker);
    }

    @PostMapping("/cliente/{idCliente}/creaTicket")
    public boolean creaTicket(@PathVariable Long idCliente, @RequestParam String testo){
        return servClie.creaTicket(idCliente,testo);
    }

    @PostMapping("/cliente/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente){
        return servClie.getCliente(idCliente);
    }

    @PostMapping("/cliente/{idCliente}/boxes")
    public List<Box> getLockerAssegnati(@PathVariable Long idCliente){
        return servClie.getBoxCliente(idCliente);
    }

    @PostMapping("/cliente/{idCliente}/boxes/open/{idBox}")
    public Box apriBoxAssegnato(@PathVariable Long idCliente, @PathVariable Long idBox){
        return apriBoxAssegnato(idCliente, idBox);
    }

    //registraCorriere e' troppo lungo eheh
    @PostMapping("cliente/{idCliente}/regCorriere")
    public void registraComeCorriere(@PathVariable Long idCliente, @RequestParam String mdt){
        servClie.aggiungiRuoloCorriere(idCliente, mdt);
    }

    @PostMapping("cliente/{idCliente}/regNegozio")
    public void registraComeNegozio(@PathVariable Long idCliente, @RequestParam String cittaNegozio,
                                    @RequestParam GenereNegozio genere){
        servClie.aggiungiRuoloNegozio(idCliente, cittaNegozio, genere);
    }

}