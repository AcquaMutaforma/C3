package it.arrp.c3.Service;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Messaggio;
import it.arrp.c3.Model.Repository.AdminRepository;
import it.arrp.c3.Model.Repository.ClienteRepository;
import it.arrp.c3.Model.Repository.MessaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Messaggio.
 */
@Service
public class ServiceMessaggio {

    @Autowired
    MessaggioRepository repoMessaggio;
    @Autowired
    AdminRepository repoAdmin;

    /**
     * Questo metodo crea un ticket dalle informazioni ricevute dal controller, un ticket va da un Cliente ad un Admin.
     * @param uuidFrom idCliente
     * @param messaggio testo Ticket
     * @return esito invio ticket, il controller deve creare un messaggio di esito
     */
    public boolean creaTicket(Long uuidFrom, String messaggio){
        Admin a = repoAdmin.getRandomAdmin();
        if(a == null)
            return false;
        Messaggio m = new Messaggio(uuidFrom, a.getIdCLiente(), messaggio);
        a.addTicket(m);
        return true;
    }

    public boolean sendRichiesta(Messaggio m){
        return false; //TODO
    }

    public boolean rimuoviTicket(Messaggio m){
        return false; //TODO
    }
}
