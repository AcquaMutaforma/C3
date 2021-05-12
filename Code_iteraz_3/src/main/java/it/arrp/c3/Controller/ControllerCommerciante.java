package it.arrp.c3.Controller;

import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Enum.GenereProdotto;
import it.arrp.c3.Model.Prodotto;
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

    /**
     * creaCorsa 2.0 - Il commerciante inserisce i dati e tramite questo controller li manda al service di
     * competenza, se il service completa l'operazione allora OK. Altrimenti ritorna al controller e poi alla view
     * il motivo di fallimento dell'operazione. Poi sarà compito del commerciante adeguarsi al problema riscontrato.
     * Esempio 1: il commerciante inserisce male uno dei 2 id, il service ritornera' "ID non trovato" o simili
     * Esempio 2: il cliente non ha un checkpoint o in esso non ci sono box disponibili, il service ritornera' qualcosa
     * come "Checkpoint cliente non valido, utilizzare assegna Locker".
     */
    @PostMapping("/commerciante/{idNegozio}/creaCorsa")
    public int creaCorsa(@RequestParam Long idCliente, @PathVariable Long idNegozio){
        return serviceNegozio.creaCorsa(idCliente, idNegozio);
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
    @PostMapping("/commerciante/{idComm}/assegnaLocker")
    public int assegnaLocker(@PathVariable Long idComm, @RequestParam Long idCliente, @RequestParam Long idLocker){
        //TODO comando "visualizzaLockers" per poi sceglierlo e usare questo metodo
        return serviceNegozio.assegnaLocker(idComm, idCliente, idLocker);
    }

    @GetMapping("/commerciante/tuttiProdotti")
    public List<Prodotto> getTuttiProdotti(){
        return serviceNegozio.getTuttiProdotti();
    }

    @GetMapping("/commerciante/{idCommerciante}/prodotti")
    public List<Prodotto> getProdotti(@PathVariable Long idCommerciante){
        return serviceNegozio.getProdottiInEvidenza(idCommerciante);
    }

    @PostMapping("/commerciante/{idCommerciante}/prodotti/new")
    public boolean creaProdotto(@PathVariable Long idCommerciante, @RequestParam String name,
                                    @RequestParam String descrizione, @RequestParam GenereProdotto genere){
        return serviceNegozio.creaProdotto(idCommerciante, name, descrizione, genere);
    }

    @PostMapping("/commerciante/{idCommerciante}/prodotti/remove")
    public boolean rimuoviProdotto(@PathVariable Long idCommerciante, @RequestParam Long idProdotto){
        return serviceNegozio.rimuoviProdotto(idCommerciante, idProdotto);
    }

    @PostMapping("/commerciante/{idCommerciante}/prodotti/aggiungi")
    public boolean aggiungiProdotto(@PathVariable Long idCommerciante, @RequestParam Long idProdotto){
        return serviceNegozio.aggiungiProdotto(idCommerciante, idProdotto);
    }

    //TODO abbiamo solo metodi per creare prodotti, forse andrebbero fatti 2 metodi, uno crea e uno aggiunge, quindi
    // forse potrebbe esserci una specie di ControllerProdotti per visualizzare tutti quelli che esistono, e aggiungere
    // quelli gia fatti, senza doverli sempre riscrivere, per ora mi fermo qui, poi lo vediamo insieme come farlo. -A
}
