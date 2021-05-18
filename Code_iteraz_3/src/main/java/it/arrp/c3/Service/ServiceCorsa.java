package it.arrp.c3.Service;

import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Negozio;
import it.arrp.c3.Model.Pacco;
import it.arrp.c3.Model.Repository.CorsaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
    CorsaRepository repoCorsa;
    @Autowired
    ServicePacco servicePacco;
    @Autowired
    ServiceCorriere serviceCorriere;
    @Autowired
    ServiceNegozio serviceNegozio;
    @Autowired
    ServiceMessaggio serviceMessaggio;
    @Autowired
    ServiceBox serviceBox;
    @Autowired
    ServiceCliente serviceCliente;

    /** Mappa per le corse rifiutate, K = idCorsa rifiutata V = lista IDCorrieri che hanno rifiutato la corsa K */
    private Map<Long, List<Long>> corseRifiutate = new HashMap<>();

    /**
     * Metodo che si occupa di inizializzare una corsa.
     * Nota: gli input vengono gia' controllati dal service negozio, quindi non li controlliamo di nuovo,
     * il box viene assegnato al cliente da serviceNegozio.
     */
    public void creaCorsa(Long idNegozio, Long idCorriere, Long idCliente, Long idBox){
        Pacco pacco = servicePacco.creaPacco(idCliente,idNegozio);
        Corsa corsa = new Corsa(pacco.getIdPacco(), idBox, idCorriere);
        assegnaCorsa(corsa,idCorriere);
        repoCorsa.save(corsa);
    }

    /** Se non c'e' nella lista delle corse rifiutate allora la inserisco, insieme all'id del corriere che la ha
     * rifiutata, cosi' da non assegnarla di nuovo a lui.
     */
    public void rifiutaCorsa(Long idCorriere, Long idCorsa) {
        Corsa c = getCorsa(idCorsa);
        List<Long> listaCorrieri;
        if(this.corseRifiutate.containsKey(idCorsa)) {
            listaCorrieri = this.corseRifiutate.get(idCorsa);
            listaCorrieri.add(c.getIdCorriere());
            this.corseRifiutate.replace(idCorsa, listaCorrieri);
        }else {
            listaCorrieri = new ArrayList<>();
            listaCorrieri.add(c.getIdCorriere());
            this.corseRifiutate.put(idCorsa,listaCorrieri);
        }
        riassegnaCorsaRifiutata(c);
    }

    /**
     * Questo metodo prova ad assegnare nuovamente una corsa che e' stata rifiutata da un corriere.
     * Inserisce la corsa nella lista delle corse fallite insieme all'id del corriere e tenta di assegnare un
     * corriere per eseguie la corsa, se ci riesce la riassegna, altrimenti cancella la corsa e la annulla
     * notificando il cliente e il negoziante.
     */
    public void riassegnaCorsaRifiutata(Corsa corsa){
        Pacco p = servicePacco.getPacco(corsa.getIdPacco());
        Negozio negozio = serviceNegozio.getNegozio(p.getIdCommerciante());//todo penso non sia il caso di prenderlo in questo modo... --Ric
        List<Corriere> listaDisponibili = serviceNegozio.getListaCorrieriDisponibili(negozio);
        //dalla lista rimuovo il corriere X se e' all'interno della lista dei corrieri che hanno rifiutato la corsa
        listaDisponibili.removeIf(x -> corseRifiutate.get(corsa.getIdCorsa()).contains(x.getIdCliente()));
        if(!listaDisponibili.isEmpty()){
            Long nuovoCorriere = listaDisponibili.get(0).getIdCliente();
            corsa.setIdCorriere(nuovoCorriere);
            assegnaCorsa(corsa, nuovoCorriere);
        }else{  //annulla corsa
            corseRifiutate.remove(corsa.getIdCorsa());
            serviceMessaggio.notificaCorsaFallita(corsa.getIdCorsa(), p.getIdCliente(), p.getIdCommerciante());
            Long idBox = corsa.getIdBox();
            serviceCliente.rimuoviBox(p.getIdCliente(),idBox);
            serviceBox.liberaBox(idBox);
        }

    }

    //nota: Diamo l'oggetto corsa dato che il corriere ha un arrayList<Corsa> in cui vengono inserite le corse da fare
    public void assegnaCorsa(Corsa corsa, Long idCorriere){
        serviceCorriere.assegnaCorsa(corsa, idCorriere);
        serviceMessaggio.notificaCorsaAssegnata(idCorriere);
    }

    /** Metodo per segnare come completa una corsa che prima era stata rifiutata
     * quindi elimino lo spazio utilizzato.
     * Corsa Rifiutata e' stata Completata
     */
    public void corsaRedivivaCompletata(Long idCliente){
        this.corseRifiutate.remove(idCliente);
    }

    //TODO check gli schemi se manca qualcosa -A
    //Questo metodo si innesca quando il corriere apre il box per consegnare il pacco,
    // per il corriere ci pensa serviceCorriere quando sblocca il box nel locker
    public void corsaCompletata(Long idCorsa){
        if(corseRifiutate.containsKey(idCorsa))
            corsaRedivivaCompletata(idCorsa);
        Corsa corsa = getCorsa(idCorsa);
        Pacco pacco = servicePacco.getPacco(corsa.getIdPacco());
        serviceMessaggio.notificaCorsaCompletata(idCorsa, pacco.getIdCliente());//invia la notifica per il completamento
    }

    public Corsa getCorsa(Long idCorsa){ return repoCorsa.findOneByIdCorsa(idCorsa); }

}