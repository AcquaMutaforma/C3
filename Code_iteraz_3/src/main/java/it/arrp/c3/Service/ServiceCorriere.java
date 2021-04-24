package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Corriere;
import it.arrp.c3.Model.Corsa;
import it.arrp.c3.Model.Enum.StatoCorriere;
import it.arrp.c3.Model.Repository.CorriereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Corriere.
 */
@Service
public class ServiceCorriere {

    @Autowired
    CorriereRepository repoCorriere;
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

    //forse il return dovrebbe essere void, ma fa comodo per verificare subito l'effetto dell'operazione
    public List<Corsa> rifiutaCorsa(Long idCorriere, Long idCorsa){
        Corriere corr = repoCorriere.findOneById(idCorriere);
        if(corr == null)
            return null;
        if(corr.getCorsa(idCorsa) == null) {
            return null;
        }else {
            serviceCorsa.rifiutaCorsa(idCorriere, idCorsa);
            corr.rimuoviCorsa(idCorsa);
        }
        return corr.getAllCorse();
    }
    public Corriere cambiaStato(Long idCorriere, StatoCorriere statoCorriere){
        Corriere c = repoCorriere.findOneById(idCorriere);
        c.setStato(statoCorriere);
        return c;
    }

    //input controllato da service Negozio
    public void assegnaCorsa(Corsa corsa, Long idCorriere) {
        Corriere corriere = getCorriere(idCorriere);
        corriere.addNuovaCorsa(corsa);
        //TODO da verificare... può andare bene cosí? --Ric
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
            Corsa c = serviceCorsa.getCorsa(idCorsa);
            serviceBox.unlock(c.getIdBox());
            //completo la corsa
            serviceCorsa.corsaCompletata(idCorsa);
            completaCorsa(getCorriere(idCorriere),idCorsa);
            return serviceBox.getBox(c.getIdBox());
        }
        return null;
    }

    private void completaCorsa(Corriere corriere, Long idCorsa) {
        //TODO
    }

    public void salvaRuoloCorriere(Long idCliente, String mdt) {
        repoCorriere.save(new Corriere(idCliente,mdt));
    }

    //TODO da valutare, dato che tecnicamente la responsabilita' sarebbe la sua probabilmente dovrebbe stare qui -A Concordo, anche se non mi piace molto passare tutto l'arraylist --Ric
    public Long getCorriereDisponibile(ArrayList<Corriere> listaCorrieriAssunti){
        for(Corriere c : listaCorrieriAssunti){
            if(c.getStato() == StatoCorriere.Attivo)
                return c.getIdCLiente();
        }
        return null;
    }
}
