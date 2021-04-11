package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Pacco;
import it.arrp.c3.Model.Repository.CorsaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Corsa.
 */
@Service
public class ServiceCorsa {

    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    ServicePacco servicePacco;
    @Autowired
    ServiceCorriere serviceCorriere;
    @Autowired
    CorsaRepository repoCorsa;

    /** Mappa per le corse rifiutate, K = idCorsa rifiutata V = lista IDCorrieri che hanno rifiutato la corsa K */
    private Map<Long, List<Long>> corseRifiutate = new HashMap<>();

    public Corsa creaCorsa(Long idCliente, Long idCommerciante, Long idCorriere){
        //TODO Dovrebbe prendere anche il box in cui andare? idk --Ric
        //TODO da implementare --Ric

        Pacco pacco =servicePacco.creaPacco(idCliente,idCommerciante);
        List<Box> idLocker = serviceCliente.getBoxCliente(idCliente);
        Corsa corsa = new Corsa(/*(long)Math.random()*100, */pacco.getIdPacco(),idLocker.get(0).getLocker().getId(),idCorriere);
        assegnaCorsa(corsa,idCorriere);
        //TODO Da implementare la chiamata sottostante, l'ho fatta a tirar via per poter andare un pelo avanti --Ric
        return corsa;
    }

    public void rifiutaCorsa(Long idCorriere, Long idCorsa) {
        if(this.corseRifiutate.get(idCorriere) == null){
            List<Long> l = new ArrayList<>();
            l.add(idCorriere);
            this.corseRifiutate.put(idCorsa, l);
        }else{
            this.corseRifiutate.get(idCorriere).add(idCorsa);
        }
        assegnaCorsa(repoCorsa.findOneById(idCorsa));
    }

    public void assegnaCorsa(Corsa corsa){
        //TODO da implementare per assegnare la corsa dopo essere stata rifiutata da qualcuno --Ric
    }

    public void assegnaCorsa(Corsa corsa, Long idCorriere){
        //TODO se c è presente nella lista delle corse rifiutate allora cerco un
        serviceCorriere.assegnaCorsa(corsa, idCorriere);
    }

    /** Metodo per segnare come completa una corsa che prima era stata completata
     * quindi elimino lo spazio utilizzato */
    public void corsaRifiutataCompletata(Long idCliente){//TODO cambiare nome al metodo, è molto confusionario --Ric
        this.corseRifiutate.remove(idCliente);
    }

    public void corsaCompletata(Long idCorsa){
//        if (corseRifiutate.containsValue(idCorsa))
//            corsaRifiutataCompletata(0L); //TODO implementare un controllo simile, forse c'é un piccolo problema con la mappa però --Ric
        //TODO
    }

    public Corsa getCorsaById(Long idCorsa) {
        return repoCorsa.findOneById(idCorsa);
    }

    //TODO manca un metodo "svuota cache" per eliminare le corse rifiutate mai effettuate

}