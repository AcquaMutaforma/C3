package it.arrp.c3.Controller;

import it.arrp.c3.Service.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdmin {

    @Autowired
    ServiceAdmin serviceAdmin;

    public void creaLocker(int latitudine, int longitudine, int dimensioniLocker) {
        serviceAdmin.creaLocker(latitudine,longitudine,dimensioniLocker);
        //TODO l'input di latitudine e longitudine e dimensioni al momento non vengono controllati, nella nostra
        // implementazione si potrebbe pensare di implementare solo l'ultima controllando che non esistano Locker con
        // le medesime coordinate. --Ric
    }

    @PostMapping("/admin/creaTecnico")
    public void creaTecnico(@RequestParam Long idCliente, @RequestParam Long idAdmin){
        serviceAdmin.creaTecnico(idCliente, idAdmin);
    }


        //TODO
}
