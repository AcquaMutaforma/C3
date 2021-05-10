package it.arrp.c3.Controller;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Tecnico;
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

    @PostMapping("/admin/{idAdmin}/locker/new")
    public boolean creaLocker(@PathVariable Long idAdmin, @RequestParam int longitudine,
                              @RequestParam int latitudine,@RequestParam int dimensioniLocker) {
        return serviceAdmin.creaLocker(idAdmin, longitudine,latitudine,dimensioniLocker);
    }

    @PostMapping("/admin/{idAdmin}/tecnico/new")
    public boolean creaTecnico(@PathVariable Long idAdmin, @RequestParam Long idCliente){
        return serviceAdmin.creaTecnico(idCliente, idAdmin);
    }

    @PostMapping("/admin/{idAdmin}/admin/new")
    public boolean creaAdmin(@PathVariable Long idAdmin, @RequestParam Long idCliente, @RequestParam String citta){
        return serviceAdmin.creaAdmin(idCliente, idAdmin, citta);
    }

    @PostMapping("/admin/{idAdmin}/tecnico/add")
    public List<Tecnico> aggiungiTecnico(@PathVariable Long idAdmin, @RequestParam Long idTecnico){
        return serviceAdmin.aggiungiTecnico(idAdmin, idTecnico);
    }

    @PostMapping("/admin/{idAdmin}/locker/off")
    public Locker turnOffLocker(@PathVariable Long idTecnico, @RequestParam Long idLocker){
        return serviceAdmin.turnOffLocker(idTecnico, idLocker);
    }

    @PostMapping("/admin/{idAdmin}/locker/on")
    public Locker turnOnLocker(@PathVariable Long idTecnico, @RequestParam Long idLocker){
        return serviceAdmin.turnOnLocker(idTecnico, idLocker);
    }

    @PostMapping("/admin/{idAdmin}/box/apri")
    public Box unlockBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceAdmin.unlockBox(idTecnico, idBox);
    }

    @PostMapping("/admin/{idAdmin}/box/chiudi")
    public Box lockBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceAdmin.lockBox(idTecnico, idBox);
    }

    @PostMapping("/admin/{idAdmin}/box/spegni")
    public Box turnOffBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceAdmin.turnOffBox(idTecnico, idBox);
    }

    @PostMapping("/admin/{idAdmin}/box/accendi")
    public Box turnOnBox(@PathVariable Long idTecnico, @RequestParam Long idBox){
        return serviceAdmin.turnOnBox(idTecnico, idBox);
    }
}
