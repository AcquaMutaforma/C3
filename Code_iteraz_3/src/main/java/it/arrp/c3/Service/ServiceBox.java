package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.Chiusura;
import it.arrp.c3.Model.Enum.StatoBox;
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

    public Box assegnaBox(Long idBox, Long idCliente){
        Box box =getBox(idBox);
        if (box==null )
            return null;
        if(box.getStatoAccensioneBox() == Accensione.Spento || box.getStato() != StatoBox.Libero)
            return null;
        box.setIdCliente(idCliente);
        box.avanzaStato();
        repoBox.save(box);
        return box;
    }
    public void liberaBox(Long idBox){
        Box box =getBox(idBox);
        if (box==null)
            return;
        box.setIdCliente(null);
        box.setStato(StatoBox.Libero);
        repoBox.save(box);
    }

    public Box unlock(Long idBox) {
        Box b = repoBox.findOneByIdBox(idBox);
        if (b != null){
            b.unlock();
            repoBox.save(b);
            return b;
        }else return null;
    }

    public Box lock(Long idBox){
        Box b = repoBox.findOneByIdBox(idBox);
        if (b != null){
            b.lock();
            repoBox.save(b);
            return b;
        }else return null;
    }
    public boolean turnOffBox(Long idBox){
        Box box = repoBox.findOneByIdBox(idBox);
        if(box == null)
            return false;
        box.turnOffBox();
        repoBox.save(box);
        return true;
    }
    public boolean turnOnBox(Long idBox){
        Box box = repoBox.findOneByIdBox(idBox);
        if(box == null)
            return false;
        box.turnOnBox();
        repoBox.save(box);
        return true;
    }

    public Box getBox(Long idBox) {
        return repoBox.findOneByIdBox(idBox);
    }

    public Box creaBox(Long idLocker) {
        Box box = new Box(idLocker);
        repoBox.save(box);
        return box;
    }

}
