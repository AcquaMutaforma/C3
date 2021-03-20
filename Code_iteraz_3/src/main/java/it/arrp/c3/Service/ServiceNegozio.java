package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Negozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti il Ruolo Negozio.
 */
@Service
public class ServiceNegozio {

    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    ServiceCorsa serviceCorsa;

    public boolean addCorriere(UUID uuidCorriere){
        //TODO da implementare --Ric
        return true;
    }
    public boolean removeCorriere(UUID uuidCorriere){
        //TODO da implementare --Ric
        return true;
    }
    public Long getCorriereDisponibile(){
        //TODO da implementare --Ric
        return null;
    }
    public boolean creaCorsa(Long uuidCliente, Long uuidCommerciante){
        //TODO da completare --Ric
        Long corriere = getCorriereDisponibile();
        if (corriere!=null){
            List<Box> box = serviceCliente.getBoxCliente(uuidCliente);
            if (box!=null){
                serviceCorsa.creaCorsa(uuidCliente,uuidCommerciante);
                return true;
            }
            return false;
        }
        return false; //di conseguenza la consegna viene negata
    }

    public List<Negozio> getNegozi(String citta) {
        //TODO
        return null;
    }

    public List<Negozio> getNegozioByName(String citta, String nome) {
        //TODO
        return null;
    }

    public List<Negozio> getNegozioByGenere(String citta, GenereNegozio genere) {
        //TODO
        return null;
    }
}
