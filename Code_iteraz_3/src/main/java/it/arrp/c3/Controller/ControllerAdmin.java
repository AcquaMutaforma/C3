package it.arrp.c3.Controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdmin {
    public void creaLocker(String latitudine, String longitudine, int dimensioniLocker) {
        //TODO da implementare controllando l'input di latitudine e longitudine --Ric
    }

    public void creaTecnico(Long idCliente){
        //serviceAdmin.creaTecnico(idCliente); //andrebbe bene cosí? idk --Ric
        //TODO da implementare controllando che l'id sia corretto --Ric
    }
        //TODO
}
