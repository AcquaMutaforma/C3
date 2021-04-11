package it.arrp.c3.Service;

import it.arrp.c3.Model.*;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Cliente.
 */
@Service
public class ServiceCliente {

    @Autowired
    ClienteRepository repoCliente;

    //TODO Ho demandato tutto ai relativi service, dw --Ric

    @Autowired
    ServiceBox serviceBox;
    @Autowired
    ServiceLocker serviceLocker;
    @Autowired
    ServiceCorriere serviceCorriere;
    @Autowired
    ServiceNegozio serviceNegozio;
    @Autowired
    ServiceMessaggio servMessaggio;

    public boolean setCheckpoint(Long idCliente, Long idLocker){
        Locker locker = serviceLocker.getLockerById(idLocker);
        if(locker == null)
            return false;
        Cliente cliente = repoCliente.findOneById(idCliente);
        cliente.setCheckpoint(locker);
        return true;
    }

    /**
     * Inserisce nella lista Box di un cliente il Box assegnato per una corsa.
     * @param boxAssegnato Box da inserire.
     */
    public void assegnamentoBox(Long idCliente, Box boxAssegnato){
        Cliente c = repoCliente.findOneById(idCliente);
        if(!(c == null)){
            c.addBox(boxAssegnato);
        }
    }

    public List<Box> getBoxCliente(Long uuidCliente) {
        //TODO qui restituisce una lista perchè vogliamo inserire i pacchi anche
        // nei box dove in teoria ci sono già oggetti comprati in precedenza? --Ric
        return repoCliente.getOne(uuidCliente).getBoxAssegnati();
    }

    public Cliente getCliente(Long id) {
        return repoCliente.findOneById(id);
    }

    public List<String> getListaRuoli(Long idCliente){
        Cliente cliente = getCliente(idCliente);
        return cliente.getListaRuoli();
    }

    /**
     * Apre il box che appartiene al cliente dato.
     * @param idCliente .
     * @param idBox .
     * @return NULL se il cliente o box non esiste, o il box non è presente nella sua lista.
     */
    //TODO ale sei sicuro che va qui ? --ale
    public Box apriBox(Long idCliente, Long idBox){
        Cliente c = getCliente(idCliente);
        if(c == null)
            return null;
        Box b = serviceBox.getBox(idBox);
        if(b == null)
            return null;
        if(c.getBoxAssegnati().contains(b)){
            for (Box box : c.getBoxAssegnati()) {
                b = box;
                if (b.getIdBox().equals(idBox)) {
                    b.unlock();
                    return b;
                }
            }
        }
        return null;
    }

    public Cliente registrazione(String nome, String email, String pass, String citta) {
        Cliente c = new Cliente(nome,email,pass,citta);
        repoCliente.save(c);
        return c;
    }

    public void aggiungiRuoloCorriere(Long idCliente, String mdt) {
        Cliente c = repoCliente.findOneById(idCliente);
        serviceCorriere.salvaRuoloCorriere(idCliente,mdt);
        c.aggiungiRuolo("Corriere");
    }

    public void aggiungiRuoloTecnico(Long idCliente){
        Cliente cliente = repoCliente.findOneById(idCliente);
        cliente.aggiungiRuolo("Tecnico");
    }

    public void aggiungiRuoloNegozio(Long idCliente, String nomeNegozio, String cittaNegozio, GenereNegozio genere) {
        Cliente c = repoCliente.findOneById(idCliente);
        serviceNegozio.salvaRuoloNegozio(idCliente, nomeNegozio, cittaNegozio, genere);
        c.aggiungiRuolo("Negozio");
    }

    public boolean creaTicket(Long idCliente, String testo){
        return servMessaggio.creaTicket(idCliente,testo);
    }
}