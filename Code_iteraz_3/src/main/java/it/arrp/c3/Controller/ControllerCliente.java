package it.arrp.c3.Controller;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCliente{
    @Autowired
    ServiceCliente servClie;

    @PostMapping("/cliente/{idCliente}/checkpoint")
    public boolean setCheckpoint(@PathVariable Long idCliente, @RequestParam Long idLocker){
        return servClie.setCheckpoint(idCliente, idLocker);
    }

    @PostMapping("/cliente/{idCliente}/creaTicket")
    public boolean creaTicket(@PathVariable Long idCliente, @RequestParam String testo){
        return servClie.creaTicket(idCliente,testo);
    }

    @GetMapping("/cliente/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente){
        return servClie.getCliente(idCliente);
    }

    @GetMapping("/cliente/{idCliente}/boxes")
    public List<Box> getLockerAssegnati(@PathVariable Long idCliente){
        return servClie.getBoxCliente(idCliente);
    }

    @GetMapping("/cliente/{idCliente}/boxes/open/{idBox}")
    public Box apriBoxAssegnato(@PathVariable Long idCliente, @PathVariable Long idBox){
        return servClie.apriBox(idCliente, idBox);
    }

    @PostMapping("cliente/{idCliente}/regCorriere")
    public void registraComeCorriere(@PathVariable Long idCliente, @RequestParam String mdt){
        servClie.aggiungiRuoloCorriere(idCliente, mdt);
    }

    @PostMapping("cliente/{idCliente}/regNegozio")
    public void registraComeNegozio(@PathVariable Long idCliente, @RequestParam String nomeNegozio,
                                    @RequestParam String cittaNegozio,
                                    @RequestParam GenereNegozio genere){
        servClie.aggiungiRuoloNegozio(idCliente,nomeNegozio, cittaNegozio, genere);
    }

    //TODO extra: la modifica dei dati come l'autenticazione è qualcosa di moooolto superfluo quindi lo saltiamo credo
}