package it.arrp.c3.Service;

import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Enum.StatoCorriere;
import it.arrp.c3.Model.Repository.CorriereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Corriere.
 */
@Service
public class ServiceCorriere {

    @Autowired
    CorriereRepository repoCorriere;

    public List<Corsa> getAllCorse(Long idCorriere){ //Rinominato per essere piu' specifico
        return repoCorriere.findOneById(idCorriere).getAllCorse();
    }

    public Corsa getCorsa(Long idCorriere, Long idCorsa){
        List<Corsa> lcorse = getAllCorse(idCorriere);
        for(Corsa c : lcorse){
            if(c.getIdCorsa().equals(idCorsa))
                return c;
        }
        return null;
    }

    public boolean rifiutaCorsa(Long idCorriere, Long idCorsa){
        //TODO da implementare --Ric
        return true;
    }
    public void cambiaStato(Long idCorriere, StatoCorriere statoCorriere){
        //TODO da implementare, anche qui penso debba prendere lo UUID del corriere --Ric
    }

    public void assegnaCorsa(Corsa corsa, Long idCorriere) {
        Corriere corriere=getCorriere(idCorriere);
        //TODO da implementare --Ric

    }

    public Corriere getCorriere(Long uuidCorriere){
        return repoCorriere.findOneById(uuidCorriere);
    }
}
