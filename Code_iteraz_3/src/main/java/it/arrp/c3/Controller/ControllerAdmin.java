package it.arrp.c3.Controller;

import it.arrp.c3.Model.*;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Service.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerAdmin {

    @Autowired
    ServiceAdmin serviceAdmin;

    @GetMapping("/admin/{idAdmin}")
    public Admin getAdmin(@PathVariable Long idAdmin){
        return serviceAdmin.getAdmin(idAdmin);
    }

    @PostMapping("/admin/{idAdmin}/tecnico/new")
    public boolean creaTecnico(@PathVariable Long idAdmin, @RequestParam Long idCliente){
        return serviceAdmin.creaTecnico(idCliente, idAdmin);
    }

    @PostMapping("/admin/{idAdmin}/locker/new")
    public boolean creaLocker(@PathVariable Long idAdmin, @RequestParam int longitudine,
                              @RequestParam int latitudine,@RequestParam int dimensioniLocker) {
        return serviceAdmin.creaLocker(idAdmin, longitudine,latitudine,dimensioniLocker);
    }

    @PostMapping("/admin/{idAdmin}/admin/new")
    public boolean creaAdmin(@PathVariable Long idAdmin, @RequestParam Long idCliente){
        return serviceAdmin.creaAdmin(idAdmin, idCliente);
    }

    @PostMapping("/admin/{idAdmin}/tecnico/add")
    public List<Tecnico> aggiungiTecnico(@PathVariable Long idAdmin, @RequestParam Long idTecnico){
        return serviceAdmin.aggiungiTecnico(idAdmin, idTecnico);
    }

    @PostMapping("/admin/{idAdmin}/locker/off")
    public Locker turnOffLocker(@PathVariable Long idAdmin, @RequestParam Long idLocker){
        return serviceAdmin.turnOffLocker(idAdmin, idLocker);
    }

    @PostMapping("/admin/{idAdmin}/locker/on")
    public Locker turnOnLocker(@PathVariable Long idAdmin, @RequestParam Long idLocker){
        return serviceAdmin.turnOnLocker(idAdmin, idLocker);
    }

    @PostMapping("/admin/{idAdmin}/box/off")
    public Box turnOffBox(@PathVariable Long idAdmin, @RequestParam Long idBox){
        return serviceAdmin.turnOffBox(idAdmin, idBox);
    }

    @PostMapping("/admin/{idAdmin}/box/on")
    public Box turnOnBox(@PathVariable Long idAdmin, @RequestParam Long idBox){
        return serviceAdmin.turnOnBox(idAdmin, idBox);
    }

    @PostMapping("/admin/{idAdmin}/box/open")
    public Box unlockBox(@PathVariable Long idAdmin, @RequestParam Long idBox){
        return serviceAdmin.unlockBox(idAdmin, idBox);
    }

    @PostMapping("/admin/{idAdmin}/box/close")
    public Box lockBox(@PathVariable Long idAdmin, @RequestParam Long idBox){
        return serviceAdmin.lockBox(idAdmin, idBox);
    }

    @PostMapping("/admin/{idAdmin}/regNegozio")
    public Negozio registraNegozio(@PathVariable Long idAdmin, @RequestBody Negozio nuovo){
        return serviceAdmin.registraNegozio(idAdmin, nuovo);
    }

    @PostMapping("/admin/{idAdmin}/tecnico/remove")
    public boolean rimuoviTecnico(@PathVariable Long idAdmin, @RequestParam Long idTecnico){
        return serviceAdmin.rimuoviTecnico(idAdmin,idTecnico);
    }

    @GetMapping("/admin/{idAdmin}/locker/get")
    public List<Locker> getLockerDisponibili(@PathVariable Long idAdmin){
        return serviceAdmin.getLockerDisponibili(idAdmin);
    }
}
