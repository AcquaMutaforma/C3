package it.arrp.c3.Controller;

import it.arrp.c3.Model.Admin;
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
}
