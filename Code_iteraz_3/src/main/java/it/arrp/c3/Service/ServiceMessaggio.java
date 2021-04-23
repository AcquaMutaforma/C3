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
    @Autowired
    ClienteRepository repoCliente;

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
        repoMessaggio.save(m);
        return true;
    }

    public boolean sendRichiesta(Long from, Long to, String messaggio){
        Messaggio m = new Messaggio(from, to , messaggio);
        repoMessaggio.save(m);
        Cliente a = repoCliente.findOneById(to);
        if(a == null)
            return false;
        a.aggiungiNotifica(m);
        return true;
    }

    public boolean rimuoviTicket(Messaggio m){
        return false; //TODO
    }

    public void nuovaNotifica(Long idCLiente, String s){
        //TODO creazione e invio della notifica -A
    }


    //TODO getMessaggio etc
}
