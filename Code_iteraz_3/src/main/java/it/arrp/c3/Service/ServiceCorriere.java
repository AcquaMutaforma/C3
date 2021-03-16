package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Enum.StatoCorriere;
import it.arrp.c3.Model.Repository.BoxRepository;
import it.arrp.c3.Model.Repository.CorriereRepository;
import it.arrp.c3.Model.Repository.CorsaRepository;
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
    @Autowired
    CorsaRepository repoCorsa;
    @Autowired
    BoxRepository repoBox;
    @Autowired
    ServiceCorsa serviceCorsa;
    @Autowired
    ServiceBox serviceBox;

    public List<Corsa> getAllCorse(Long idCorriere){ //Rinominato per essere piu' specifico
        return repoCorriere.findOneById(idCorriere).getAllCorse();
    }

    public Corsa getCorsa(Long idCorriere, Long idCorsa){
        return repoCorriere.findOneById(idCorriere).getCorsa(idCorsa);
    }

    public List<Corsa> rifiutaCorsa(Long idCorriere, Long idCorsa){
        Corriere corr = repoCorriere.findOneById(idCorriere);
        if(corr == null)
            return null;
        if(corr.getCorsa(idCorsa) == null) {
            return null;
        }else {
            serviceCorsa.rifiutaCorsa(idCorriere, idCorsa); //TODO controllare che faccia le cose giuste
            corr.rimuoviCorsa(idCorsa);
        }
        return corr.getAllCorse();
    }
    public Corriere cambiaStato(Long idCorriere, StatoCorriere statoCorriere){
        Corriere c = repoCorriere.findOneById(idCorriere);
        c.setStato(statoCorriere);
        return c;
    }

    public void assegnaCorsa(Corsa corsa, Long idCorriere) {
        Corriere corriere=getCorriere(idCorriere);
        //TODO da implementare --Ric
    }

    public Corriere getCorriere(Long uuidCorriere){
        return repoCorriere.findOneById(uuidCorriere);
    }

    /**
     * Sblocca il Box per inserire il pacco da consegnare e attraverso questo "innesca" il completamento
     * della corsa assegnata.
     * @param idCorriere identifica il corriere che deve aprire il box.
     * @param idCorsa identifica la corsa per vedere le info e completarla.
     */
    public Box unlock(Long idCorriere, Long idCorsa) {
        //TODO non mi piace come lo ho fatto, riguardare --aley
        if(getCorsa(idCorriere,idCorsa) != null){
            //sblocco il box
            Corsa c = repoCorsa.findOneById(idCorsa);
            Box b = repoBox.findOneById(c.getIdBox());
            serviceBox.unlock(b.getIdBox());
            //completo la corsa
            serviceCorsa.corsaCompletata(idCorsa);
            return b;
        }
        return null;
    }
}
