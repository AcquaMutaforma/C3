package it.arrp.c3.Controller;

import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Service.ServiceCorriere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/corriere/{idCorriere}/Corse")
    public List<Corsa> getAllCorse(@PathVariable Long idCorriere){
        return serviceCorriere.getAllCorse(idCorriere);
    }


    //cambia stato
    //rifiuta corsa
    //apri box
    //getCorsa
}
