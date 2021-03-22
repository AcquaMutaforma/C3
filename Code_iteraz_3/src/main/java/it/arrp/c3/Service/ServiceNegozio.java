package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Negozio;
import it.arrp.c3.Model.Repository.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti il Ruolo Negozio.
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
        Negozio neg = getNegozioById(idNegozio);
        if(neg == null)
            return false;
        Corriere corr = serviceCorriere.getCorriere(idCorriere);
        if(corr == null)
            return false;
        return serviceNegozio.addCorriere(idNegozio, idCorriere);
    }

    //TODO tra add e remove il primo pezzo è uguale, se succede un'altra volta forse
    // è il caso di creare un metodo apposta per la verifica e il get -A
    public boolean removeCorriere(Long idNegozio, Long idCorriere){
        Negozio neg = repoNegozio.findOneById(idNegozio);
        if(neg == null)
            return false;
        Corriere corr = serviceCorriere.getCorriere(idCorriere);
        if(corr == null)
            return false;
        return serviceNegozio.removeCorriere(idNegozio, idCorriere);
    }

    public Long getCorriereDisponibile(Long idCommerciante){
        Negozio negozio =getNegozioById(idCommerciante);
        ArrayList<Corriere> corriereArrayList;
        if (negozio!=null)
            corriereArrayList= negozio.getListaCorrieriAssunti();
        //TODO da implementare --Ric
        return null;
    }
    public boolean creaCorsa(Long uuidCliente, Long uuidCommerciante){
        //TODO da completare --Ric
        Long corriere = getCorriereDisponibile(uuidCommerciante);
        if (corriere!=null){
            List<Box> box = serviceCliente.getBoxCliente(uuidCliente);
            if (box!=null){
                serviceCorsa.creaCorsa(uuidCliente,uuidCommerciante, corriere);
                return true;
            }
            return false;
        }
        return false; //di conseguenza la consegna viene negata
    }

    private Negozio getNegozioById(Long idNegozio){
        return this.repoNegozio.findOneById(idNegozio);
    }

    public List<Negozio> getNegozi(String citta) {
        List<Negozio> lista = this.repoNegozio.findAll();
        lista.removeIf(n -> !(n.getCittaNegozio().equals(citta)));
        return lista;
        //TODO forse potrebbe esistere una qualche richiesta SQL che ci permette di non fare questa roba, to check -A
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
}
