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

    public void creaLocker(String latitudine, String longitudine, int dimensioniLocker) {
        //TODO da implementare controllando l'input di latitudine e longitudine --Ric
    }

    @PostMapping("/admin/creaTecnico")
    public void creaTecnico(@RequestParam Long idCliente, @RequestParam Long idAdmin){
        serviceAdmin.creaTecnico(idCliente, idAdmin); //andrebbe bene cosí? idk --Ric  yesss -a
        //TODO da implementare controllando che l'id sia corretto --Ric
        //ci pensa il service, qua si limita a riceve dati
    }


        //TODO
}
