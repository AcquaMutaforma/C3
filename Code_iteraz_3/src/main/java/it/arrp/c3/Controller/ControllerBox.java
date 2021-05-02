package it.arrp.c3.Controller;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Service.ServiceBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simula l'oggetto fisico
 */
@RestController
public class ControllerBox {

    @Autowired
    ServiceBox serviceBox;

    @GetMapping("/box/{idBox}/chiudi")
    public Box chiudiBox(@PathVariable Long idBox){ return serviceBox.lock(idBox); }

    @GetMapping("/box/{idBox}/apri")
    public Box apriBox(@PathVariable Long idBox){ return serviceBox.unlock(idBox); }

    @GetMapping("/box/{idBox}")
    public Box getBox(@PathVariable Long idBox){
        return serviceBox.getBox(idBox);
    }

}
