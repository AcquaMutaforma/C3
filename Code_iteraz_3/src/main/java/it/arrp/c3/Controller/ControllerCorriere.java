package it.arrp.c3.Controller;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Enum.StatoCorriere;
import it.arrp.c3.Service.ServiceCorriere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCorriere {

    @Autowired
    ServiceCorriere serviceCorriere;

    @GetMapping("/corriere/{idCorriere}")
    public Corriere getCorriere(@PathVariable Long idCorriere){
        return serviceCorriere.getCorriere(idCorriere);
    }

    @GetMapping("/corriere/{idCorriere}/corsa/{idCorsa}")
    public Corsa getCorsa(@PathVariable Long idCorriere, @PathVariable Long idCorsa){
        return serviceCorriere.getCorsa(idCorriere, idCorsa);
    }

    @GetMapping("/corriere/{idCorriere}/corsa")
    public List<Corsa> getAllCorse(@PathVariable Long idCorriere){
        return serviceCorriere.getAllCorse(idCorriere);
    }

    @PostMapping("/corriere/{idCorriere}/stato")
    public Corriere setStato(@PathVariable Long idCorriere, @RequestParam StatoCorriere stato){
        return serviceCorriere.cambiaStato(idCorriere, stato);
    }

    @PostMapping("/corriere/{idCorriere}/corsa/unlock")
    public Box unlockBox(@PathVariable Long idCorriere, @RequestParam Long idCorsa){
        return serviceCorriere.unlock(idCorriere, idCorsa);
    }

    @PostMapping("/corriere/{idCorriere}/corsa/rifiuta")
    public List<Corsa> rifiutaCorsa(@PathVariable Long idCorriere, @RequestParam Long idCorsa){
        return serviceCorriere.rifiutaCorsa(idCorriere, idCorsa);
    }

}