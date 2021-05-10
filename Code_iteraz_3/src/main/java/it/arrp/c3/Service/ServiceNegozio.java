package it.arrp.c3.Service;

import it.arrp.c3.Model.*;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Enum.GenereProdotto;
import it.arrp.c3.Model.Enum.StatoCorriere;
import it.arrp.c3.Model.Repository.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti il Ruolo Negozio.
 * Quando ci riferiamo al cliente viene chiamato IDCommerciante, mentre quando ci riferiamo
 * al negozio come oggetto fisico usiamo IDNegozio.
 */
@Service
public class ServiceNegozio {

    @Autowired
    NegozioRepository repoNegozio;
    @Autowired
    ServiceNegozio serviceNegozio;
    @Autowired
    ServiceCorriere serviceCorriere;
    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    ServiceCorsa serviceCorsa;
    @Autowired
    ServiceLocker serviceLocker;
    @Autowired
    ServiceProdotto serviceProdotto;

    public boolean addCorriere(Long idNegozio, Long idCorriere){
        if (controllaInput(idNegozio,idCorriere))
            return false;
        return serviceNegozio.addCorriere(idNegozio, idCorriere);
    }

    public boolean removeCorriere(Long idNegozio, Long idCorriere){
        if (controllaInput(idNegozio,idCorriere))
            return false;
        return serviceNegozio.removeCorriere(idNegozio, idCorriere);
    }

    private boolean controllaInput(Long idNegozio, Long idCorriere) {
        Negozio neg = repoNegozio.findOneById(idNegozio);
        Corriere corr = serviceCorriere.getCorriere(idCorriere);
        return neg == null || corr == null;
    }

    public Long getCorriereDisponibile(Long idCommerciante){
        Negozio negozio = getNegozio(idCommerciante);
        if (negozio == null)
            return null;
        return getListaCorrieriDisponibili(negozio).get(0).getIdCLiente();
    }

    public List<Corriere> getListaCorrieriDisponibili(Negozio negozio){
        List<Corriere> lista = negozio.getListaCorrieriAssunti();
        lista.removeIf(x-> !(x.getStato() == StatoCorriere.Attivo));
        return lista;
    }

    /**
     * Questo metodo chiede di generare una corsa al relativo service.
     * Returns 1 se non ci sono stati problemi
     * Returns 0 se il cliente non ha box assegnati
     * Returns -1 se non vi e' nessun corriere disponibile
     * Returns -2 se uno dei codici identificativi é errato
     *
     * Nota: Gli input e oggetti utilizzati vengono controllati qui e in caso positivo service corsa si
     * occupa di avviare il tutto, senza ricontrollare i dati.
     *
     * TODO Aggioranre il VPP, con creaCorsa del serviceNegozio, il checkpoint del cliente viene gestito
     *  da ServiceLocker e non da serviceCliente, è lui che prova ad assegnare un box.
     */
    public int creaCorsa(Long idCliente, Long idNegozio){
        if(controllaInputCorsa(idCliente, idNegozio))
            return -2;
        Long idCorriere = getCorriereDisponibile(idNegozio);
        if(idCorriere!=null){
            Long idBox = serviceLocker.assegnaBox(idCliente);
            if(idBox != null){
                serviceCorsa.creaCorsa(idNegozio, idCorriere, idCliente, idBox);
                return 1;
            }else return 0;
        }else return -1;
    }

    /**
     * Questo metodo assegna un locker al cliente in cui mandare il pacco e inizializza la corsa.
     * Il cliente potrebbe non avere un checkpoint quindi prendere il locker piu vicino a quello inserito non si puo
     * fare, una alternativa e' valutare tutti i locker della citta' in base alla distanza dal negozio, inserendo
     * la variabile con le coordinate per il negozio.
     * Una seconda opzione potrebbe essere: far inserire l'id del locker al commerciante, che puo' vedere dal suo
     * controller la lista di questi, magari inserendo una variabile nome nel locker tipo "piazza dante".
     */
    public int assegnaLocker(Long idCliente, Long idNegozio, Long idLocker){
        Cliente cliente = serviceCliente.getCliente(idCliente);
        Negozio negozio = getNegozio(idNegozio);
        Locker locker = serviceLocker.getLockerById(idLocker);
        if(cliente == null || negozio == null || locker == null)
            return -2;  //codici inseriti errati
        if(serviceLocker.getBoxDisponibile(idLocker) == null)
            return -3; //box non disponibili
        serviceCliente.setCheckpoint(idCliente, idLocker);
        return creaCorsa(idCliente, idNegozio);
    }

    private boolean controllaInputCorsa(Long idCliente, Long idCommerciante) {
        Cliente cliente = serviceCliente.getCliente(idCliente);
        Negozio commerciante = repoNegozio.findOneById(idCommerciante);
        return cliente == null || commerciante == null;
    }

    public List<Negozio> getNegoziByCitta(String citta) {
        List<Negozio> lista = this.repoNegozio.findAll();
        lista.removeIf(n -> !(n.getCittaNegozio().equals(citta)));
        return lista;
    }

    public List<Negozio> getNegozioByName(String citta, String nome) {
        List<Negozio> lista = getNegoziByCitta(citta);
        lista.removeIf(x -> !(x.getNomeNegozio().equals(nome)));
        return lista;
    }

    public List<Negozio> getNegozioByGenere(String citta, GenereNegozio genere) {
        List<Negozio> lista = getNegoziByCitta(citta);
        lista.removeIf(x -> !(x.getGenereNegozio() == genere));
        return lista;
    }

    public List<Corriere> getCorrieri(Long idCommerciante) {
        Negozio n = getNegozio(idCommerciante);
        if(n == null)
            return null;
        return n.getListaCorrieriAssunti();
    }

    public void salvaRuoloNegozio(Long idCliente, String nomeNegozio, String cittaNegozio, GenereNegozio genere) {
        repoNegozio.save(new Negozio(idCliente,nomeNegozio,cittaNegozio,genere));
    }

    public Negozio getNegozio(Long id){ return repoNegozio.findOneById(id); }

    public boolean aggiungiProdotto(Long idNegozio, String nome, String descrizione, GenereProdotto genere){
        Negozio negozio = getNegozio(idNegozio);
        if(negozio == null)
            return false;
        Prodotto p = serviceProdotto.creaProdotto(nome, descrizione, genere);
        if(p == null)
            return false;
        else return negozio.aggiungiProdotto(p);
    }

    public boolean rimuoviProdotto(Long idNegozio, Long idProdotto){
        Negozio negozio = getNegozio(idNegozio);
        if(negozio == null)
            return false;
        Prodotto prodotto = serviceProdotto.getProdotto(idProdotto);
        if(prodotto == null)
            return false;
        return negozio.rimuoviProdotto(prodotto);
    }

    public Prodotto getProdotto(Long idNegozio, Long idProdotto){
        Negozio negozio = getNegozio(idNegozio);
        if(negozio == null)
            return null;
        Prodotto prodotto = serviceProdotto.getProdotto(idProdotto);
        if(prodotto == null)
            return null;
        return negozio.getListaProdottiInEvidenza().contains(prodotto)? prodotto: null;
    }

    public List<Prodotto> getProdottiInEvidenza(Long idCommerciante) {
        Negozio n = getNegozio(idCommerciante);
        if(n == null)
            return null;
        return n.getListaProdottiInEvidenza();
    }

    public List<Prodotto> getTuttiProdotti(){
        return serviceProdotto.getProdottoAll();
    }
}
