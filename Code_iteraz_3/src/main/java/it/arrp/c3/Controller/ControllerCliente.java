package it.arrp.c3.Controller;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.TipoRuolo;
import it.arrp.c3.Model.Messaggio;
import it.arrp.c3.Model.TipoRuoloWrapper;
import it.arrp.c3.Service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCliente{
    @Autowired
    ServiceCliente serviceCliente;

    @PostMapping("/cliente/{idCliente}/checkpoint/add")
    public boolean setCheckpoint(@PathVariable Long idCliente, @RequestParam Long idLocker){
        return serviceCliente.setCheckpoint(idCliente, idLocker);
    }

    @GetMapping("/cliente/{idCliente}/checkpoint/remove")
    public void rimuoviCheckpoint(@PathVariable Long idCliente){
        serviceCliente.rimuoviCheckpoint(idCliente);
    }

    @PostMapping("/cliente/{idCliente}/ticket")
    public boolean creaTicket(@PathVariable Long idCliente, @RequestParam String testo){
        return serviceCliente.creaTicket(idCliente,testo);
    }

    @GetMapping("/cliente/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente){
        return serviceCliente.getCliente(idCliente);
    }

    /*Forse non e' bellissimo il tipo di ritorno, ma con questo la view che non abbiamo potrebbe
    * avere meno problemi a visualizzare il tutto, e non deve richiedere i box un'altra volta */
    @GetMapping("/cliente/{idCliente}/box")
    public List<Box> getBoxAssegnati(@PathVariable Long idCliente){
        return serviceCliente.getBoxCliente(idCliente);
    }

    @PostMapping("/cliente/{idCliente}/box/open")
    public Box apriBoxAssegnato(@PathVariable Long idCliente, @RequestParam Long idBox){
        return serviceCliente.apriBox(idCliente, idBox);
    }

    @PostMapping("/cliente/{idCliente}/regCorriere")
    public void registraComeCorriere(@PathVariable Long idCliente, @RequestParam String mdt){
        serviceCliente.aggiungiRuoloCorriere(idCliente, mdt);
    }

    @DeleteMapping("/cliente/{idCliente}/rimuoviRuolo")
    public void rimuoviRuolo(@PathVariable Long idCliente, @RequestParam String ruolo){
        ruolo = ruolo.toUpperCase();
        switch (ruolo){
            case "TECNICO":
                serviceCliente.rimuoviRuolo(idCliente, new TipoRuoloWrapper(TipoRuolo.Tecnico));

                break;
            case "CORRIERE":
                serviceCliente.rimuoviRuolo(idCliente,new TipoRuoloWrapper(TipoRuolo.Corriere));
                break;
            case "NEGOZIO":
                serviceCliente.rimuoviRuolo(idCliente,new TipoRuoloWrapper(TipoRuolo.Negozio));
                break;
            default:
                //TODO stampa di un errore o eliminazione di tutti i ruoli? oppure admin?  --Ric
                break;
        }
    }

    @GetMapping("/cliente/{idCliente}/listaRuoli")
    public List<TipoRuoloWrapper> getRuoliCliente(@PathVariable Long idCliente){
        return serviceCliente.getListaRuoli(idCliente);
    }

    @GetMapping("/cliente/{idCliente}/notifiche/get")
    public List<Messaggio> getNotifiche(@PathVariable Long idCliente){
        return serviceCliente.getNotifiche(idCliente);
    }

    //TODO extra: la modifica dei dati come l'autenticazione è qualcosa di moooolto superfluo quindi lo saltiamo credo
}