package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Negozio;
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
        Negozio negozio = getNegozioById(idCommerciante);
        if (negozio == null)
            return null;
        return serviceCorriere.getCorriereDisponibile(negozio.getListaCorrieriAssunti());
        //TODO da implementare la scelta del corriere disponibile all'interno della lista
        // (quindi controllo dello stato etc etc)--Ric
    }

    /**
     * Questo metodo chiede di generare una corsa al relativo service.
     *
     * Returns 1 se non ci sono stati problemi, 0 se il cliente non ha box assegnati, -1 se non vi é
     * nessun corriere disponibile e -2 se uno dei codici identificativi é errato.
     * todo descrivere bene gli int di ritorno          Fatto nella documentazione, credo -R
     */
    public int creaCorsa(Long idCliente, Long idCommerciante){
        if(controllaInputCorsa(idCliente, idCommerciante))
            return -2; //errore id non valido
        Long idCorriere = getCorriereDisponibile(idCommerciante);
        if (idCorriere!=null){
            List<Box> box = serviceCliente.getBoxCliente(idCliente);
            if (box!=null){
                serviceCorsa.creaCorsa(idCliente,idCommerciante, idCorriere);
                return 1;
            }
            return 0;
        }
        return -1; //di conseguenza la consegna viene negata
    }

    private boolean controllaInputCorsa(Long idCliente, Long idCommerciante) {
        Cliente cliente = serviceCliente.getCliente(idCliente);
        Negozio commerciante = repoNegozio.findOneById(idCommerciante);
        return cliente == null || commerciante == null;
    }

    private Negozio getNegozioById(Long idNegozio){
        return this.repoNegozio.findOneById(idNegozio);
    }

    public List<Negozio> getNegozi(String citta) {
        List<Negozio> lista = this.repoNegozio.findAll();
        lista.removeIf(n -> !(n.getCittaNegozio().equals(citta)));
        return lista;
        //TODO forse potrebbe esistere una qualche richiesta SQL che ci permette di non fare questa roba, to check -A
        //TODO sicuramente sí, ma al momento potremmo lasciare
        // cosí perché andiamo ad usare db locali, in un secondo momento si vedrà. --Ric
    }

    public List<Negozio> getNegozioByName(String citta, String nome) {
        List<Negozio> lista = getNegozi(citta);
        lista.removeIf(x -> !(x.getNomeNegozio().equals(nome)));
        return lista;
        //TODO forse potrebbe esistere una qualche richiesta SQL che ci permette di non fare questa roba, to check -A
    }

    public List<Negozio> getNegozioByGenere(String citta, GenereNegozio genere) {
        //TODO
        return null;
    }

    public List<Corriere> getCorrieri(Long idCommerciante) {
        Negozio n = getNegozioById(idCommerciante);
        if(n == null)
            return null;
        return n.getListaCorrieriAssunti();
    }

    public void salvaRuoloNegozio(Long idCliente, String nomeNegozio, String cittaNegozio, GenereNegozio genere) {
        repoNegozio.save(new Negozio(idCliente,nomeNegozio,cittaNegozio,genere));
    }
}
