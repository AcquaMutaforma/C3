package it.arrp.c3.Controller;

import it.arrp.c3.Service.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdmin {

    @Autowired
    ServiceAdmin serviceAdmin;

    @PostMapping("/admin/{idAdmin}/locker/new")
    public boolean creaLocker(@PathVariable Long idAdmin, @RequestParam int longitudine,
                              @RequestParam int latitudine,@RequestParam int dimensioniLocker) {
        return serviceAdmin.creaLocker(idAdmin, longitudine,latitudine,dimensioniLocker);
    }

    @PostMapping("/admin/{idAdmin}/creaTecnico")
    public boolean creaTecnico(@PathVariable Long idAdmin, @RequestParam Long idCliente){
        return serviceAdmin.creaTecnico(idCliente, idAdmin);
    }

    @PostMapping("/admin/{idAdmin}/creaAdmin")
    public boolean creaAdmin(@RequestParam Long idCliente, @RequestParam Long idAdmin, @RequestParam String citta){
        return serviceAdmin.creaAdmin(idCliente, idAdmin, citta);
    }

        //TODO aggiungi un tecnico
}
