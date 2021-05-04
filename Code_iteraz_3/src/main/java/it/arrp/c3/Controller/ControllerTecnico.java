package it.arrp.c3.Controller;

import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Tecnico;
import it.arrp.c3.Service.ServiceTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerTecnico {

    @Autowired
    ServiceTecnico serviceTecnico;

    @GetMapping("/tecnico/{idTecnico}")
    public Tecnico getTecnico(@PathVariable Long idTecnico){
        return serviceTecnico.getTecnico(idTecnico);
    }

    @PostMapping("/tecnico/{idTecnico}/locker/set")
    public Locker setLockerAttivo(@PathVariable Long idTecnico, @RequestParam Long idLocker){
        return serviceTecnico.impostaLockerAttivo(idTecnico, idLocker);
    }

    @GetMapping("/tecnico/{idTecnico}/locker/remove")
    public boolean removeLockerAttivo(@PathVariable Long idTecnico){
        return serviceTecnico.rimuoviLockerAttivo(idTecnico);
    }


}
