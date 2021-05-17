package it.arrp.c3.Controller;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Tecnico;
import it.arrp.c3.Service.ServiceTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/tecnico/{idTecnico}/locker/off")
    public Locker turnOffLocker(@PathVariable Long idTecnico, @RequestParam Long idLocker){
        return serviceTecnico.turnOffLocker(idTecnico, idLocker);
    }

    @PostMapping("/tecnico/{idTecnico}/locker/on")
    public Locker turnOnLocker(@PathVariable Long idTecnico, @RequestParam Long idLocker){
        return serviceTecnico.turnOnLocker(idTecnico, idLocker);
    }

    @PostMapping("/tecnico/{idTecnico}/box/apri")
    public Box unlockBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceTecnico.unlockBox(idTecnico, idBox);
    }

    @PostMapping("/tecnico/{idTecnico}/box/chiudi")
    public Box lockBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceTecnico.lockBox(idTecnico, idBox);
    }

    @PostMapping("/tecnico/{idTecnico}/box/spegni")
    public Box turnOffBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceTecnico.turnOffBox(idTecnico, idBox);
    }

    @PostMapping("/tecnico/{idTecnico}/box/accendi")
    public Box turnOnBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceTecnico.turnOnBox(idTecnico, idBox);
    }

    @GetMapping("/tecnico/{idTecnico}/locker/get")
    public List<Locker> getLockerDisponibili(@PathVariable Long idTecnico){
        return serviceTecnico.getLockerDisponibili(idTecnico);
    }

}
