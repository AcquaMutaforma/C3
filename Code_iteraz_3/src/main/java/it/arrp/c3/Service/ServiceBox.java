package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Box.
 */
@Service
public class ServiceBox {

    @Autowired
    BoxRepository repoBox;

    public Box assegnaBox(Long uuidCliente){
        //TODO da implementare --Ric
        return new Box();
    }
    public boolean liberaBox(Long idBox){
        //TODO da implementare (forse diventa void?) --Ric
        return true;
    }

    public boolean unlock(Long idBox) {
        Box b = repoBox.findOneById(idBox);
        if (b != null){
            b.unlock();
            return true;
        }else return false;
    }
    public boolean lock(Long idBox){
        Box b = repoBox.findOneById(idBox);
        if(b == null)
            return false;
        b.avanzaStato();
        return true;
    }
    public boolean turnOffBox(Long idBox){
        repoBox.findOneById(idBox).turnOffBox();
        return true;
    }
    public boolean turnOnBox(Long idBox){
        repoBox.findOneById(idBox).turnOnBox();
        return true;
    }

    public Box getBox(Long idBox) {
        return repoBox.findOneById(idBox);
    }
}
