package it.arrp.c3.Service;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Messaggio;
import it.arrp.c3.Model.Repository.MessaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Messaggio.
 */
@Service
public class ServiceMessaggio {
    private static final String CORSACOMPLETATA="É stata completata la Corsa con codice identificativo ";
    private static final String CORSANONESEGUITA = "Non é stato possibile portare a termine la corsa con codice identificativo ";
    private static final Long SYSTEM = 0L;

    @Autowired
    MessaggioRepository repoMessaggio;
    @Autowired
    ServiceAdmin serviceAdmin;
    @Autowired
    ServiceCliente serviceCliente;

    /**
     * Questo metodo invia il messaggio creato dagli altri metodi.
     */
    private void sendMessaggio(Messaggio m){
        Cliente destinatario = serviceCliente.getCliente(m.getIdDestinatario());
        destinatario.aggiungiNotifica(m);
        repoMessaggio.save(m);
    }

    /**
     * Questo metodo crea un ticket dalle informazioni ricevute dal controller, un ticket va da un Cliente ad un Admin.
     * @param idMittente idCliente
     * @param messaggio testo Ticket
     * @return esito invio ticket, il controller deve creare un messaggio di esito
     */
    public boolean creaTicket(Long idMittente, String messaggio){
        Admin a = serviceAdmin.getRandomAdmin();
        if(a == null)
            return false;
        sendMessaggio(new Messaggio(idMittente, a.getIdCliente(), messaggio));
        return true;
    }

    public boolean sendRichiesta(Long mittente, Long destinatario, String messaggio){
        Cliente dest = serviceCliente.getCliente(destinatario);
        if(dest == null)
            return false;
        Messaggio m = new Messaggio(mittente, destinatario , messaggio);
        sendMessaggio(m);
        return true;
    }

    //nota: gli input vengono controllati gia da serviceNegozio.
    // Questo viene chiamato da serviceCorsa
    public void notificaCorsaFallita(Long idCorsa, Long idCliente, Long idNegozio){
        String testoNotifica = CORSANONESEGUITA + idCorsa ;
        sendMessaggio(new Messaggio(SYSTEM, idCliente, testoNotifica+"\nSi ritiri il pacco al Negozio"));
        sendMessaggio(new Messaggio(SYSTEM, idNegozio, testoNotifica));
    }

    public void notificaCorsaCompletata(Long idCorsa, Long idCliente){
        String testoNotifica = CORSACOMPLETATA + idCorsa ;
        sendMessaggio(new Messaggio(SYSTEM, idCliente, testoNotifica));
    }

    public void notificaCorsaAssegnata(Long idCorriere) {
        String testoNotifica = "Ti e' stata assegnata una nuova corsa!";
        sendMessaggio(new Messaggio(SYSTEM, idCorriere, testoNotifica));
    }

    /*
    public boolean rimuoviTicket(Messaggio m){
        repoMessaggio.delete(m);
        return true;
        //TODO implementazione futura per rimuovere cose dal DB
    }
     */

    public Messaggio getMessaggio(Long idMessaggio){
        return repoMessaggio.findOneByIdMessaggio(idMessaggio);
    }

}
