package it.arrp.c3.Controller;

import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Service.ServiceNegozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe che si occupa di gestire le operazioni riguardanti il Ruolo Commerciante.
 */
@RestController
public class ControllerCommerciante {
    @Autowired
    ServiceNegozio serviceNegozio;

    @PostMapping("/commerciante/creaCorsa")
    public void creaCorsa(@RequestParam Long uuidCliente, @RequestParam Long uuidNegozio){
        //TODO da finire
        if (serviceNegozio.creaCorsa(uuidCliente,uuidNegozio)){
            //stampa qualcosa, è andato tutto bene
        }
        else{
            //c'è stato un errore
        }
    }

    @GetMapping("/commerciante/{idCommerciante}/corrieri")
    public List<Corriere> getCorrieri(@PathVariable Long idCommerciante){
        return serviceNegozio.getCorrieri(idCommerciante);
    }

    @PostMapping("/commerciante/{idComm}/corrieri/add")
    public boolean addCorriere(@PathVariable Long idComm, @RequestParam Long idCorr){
        return serviceNegozio.addCorriere(idComm,idCorr);
    }

    @PostMapping("/commerciante/{idComm}/corrieri/remove")
    public boolean rmCorriere(@PathVariable Long idComm, @RequestParam Long idCorr){
        return serviceNegozio.removeCorriere(idComm,idCorr);
    }

    /*
    Aspetto prima di creare il caos, ne parliamo il 23/3 --aley

    Se assegnamo un Locker è possibile che tra 5 sec quando ha creato la corsa non è più disponibile un box,
    quindi siamo al punto di partenza, possiamo "prenotare" direttamente un box, dato che questa azione si
    avvia solo quando il commerciante deve consegnare una corsa, ma a questo punto forse conviene farlo fare
    a crea corsa, ma avrebbe troppe responsabilità quindi la soluzione ottimale forse e':  creaCorsa propone
    assegna locker nel caso in cui un cliente non abbia un checkpoint o lì non ci siano box disponibili, allora
    può scegliere se annullare la consegna oppure "prenotare" un box che viene scelto con assegnaLocker (o assegnaBox)
    mettendo direttamente il box a Occupato e mandandolo a creaCorsa che ignorerà il fatto che è occupato.
    Quindi questo metodo rimane giusto per farlo chiamare dalla view nel caso in cui al cliente serve un box/locker.

    SOLUZIONE DECENTE, Possiamo usare assegna locker per poi fargli chiamare creaCorsa ovvero: se creaCorsa da esito
    negativo perché il cliente non ha un box allora usiamo assegnaBox, che "prenota" un box e lo utilizza per chiamare
    crea corsa direttamente con il service, per fare questo va creato un altro metodo creaCorsa in serviceNegozio che
    accetta come input anche un idBox.
     */
    @PostMapping("/commerciante/{idComm}/assegnaBox")
    public boolean assegnaLocker(){
        //TODO
        return false;
    }

    //TODO: agg/rm/get prodotto in evidenza
}
