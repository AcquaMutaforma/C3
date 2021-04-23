package it.arrp.c3.Service;

import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Negozio;
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

    public void riassegnaCorsaRifiutata(Corsa corsa){
        Pacco p = servicePacco.getPacco(corsa.getIdPacco());
        Negozio negozio = serviceNegozio.getNegozio(p.getIdCommerciante());
        List<Long> listaDisponibili = serviceNegozio.getListaCorrieriDisponibili(negozio.getIdCLiente());
        List<Long> listaCorrieriNo = this.corseRifiutate.get(corsa.getIdCorsa());
        for( Long corr : listaCorrieriNo){
            listaDisponibili.remove(corr);
        }
        if(!listaDisponibili.isEmpty()){
            Long nuovoCorriere = listaDisponibili.get(0);
            corsa.setIdCorriere(nuovoCorriere);
            assegnaCorsa(corsa, nuovoCorriere);
        }else{
            //todo: da valutare se puo' andare bene o meno il testo delle notifiche -A
            this.corseRifiutate.remove(corsa.getIdCorsa());
            String errore = "Impossibile eseguire corsa, i corrieri disponibili sono esauriti.";
            serviceMessaggio.nuovaNotifica(negozio.getIdCLiente(), errore+"\nIDCorsa : "+corsa.getIdCorsa()+
                    "\tIDCliente : "+p.getIdCliente());
            serviceMessaggio.nuovaNotifica(p.getIdCliente(), "Impossibile eseguire la corsa, ritirare i prodotti" +
                    "al negozio.");
            Long idBox = corsa.getIdBox();
            serviceCliente.getCliente(p.getIdCliente()).removeBox(idBox);
            serviceBox.liberaBox(idBox);
        }

    }

    public void assegnaCorsa(Corsa corsa, Long idCorriere){
        //TODO da valutare se lasciare l'oggetto intero Corsa o metterci solo l'id in modo da non "caricare troppo peso" --Ric
        serviceCorriere.assegnaCorsa(corsa, idCorriere);
    }

    /** Metodo per segnare come completa una corsa che prima era stata rifiutata
     * quindi elimino lo spazio utilizzato.
     * Corsa Rifiutata e' stata Completata
     * todo: non ho idee per il nome, come la metti e' ambiguo -A
     */
    public void corsaRCompletata(Long idCliente){
        this.corseRifiutate.remove(idCliente);
    }

    //TODO check gli schemi se manca qualcosa -A
    public void corsaCompletata(Long idCorsa){
        if(corseRifiutate.containsKey(idCorsa))
            corsaRCompletata(idCorsa);
        Corsa corsa = getCorsa(idCorsa);
        Pacco pacco = servicePacco.getPacco(corsa.getIdPacco());
        //per il corriere ci pensa serviceCorriere
        serviceBox.liberaBox(corsa.getIdBox());
        //TODO modificare la notifica che ho scritto *facepalm* -A
        serviceMessaggio.nuovaNotifica(pacco.getIdCliente(), "Corsa completata!");
    }

    public Corsa getCorsa(Long idCorsa){ return repoCorsa.findOneById(idCorsa); }

    //TODO manca un metodo "svuota cache" per eliminare le corse rifiutate mai effettuate

}