package it.arrp.c3.Service;

import it.arrp.c3.Model.*;
import it.arrp.c3.Model.Enum.Accensione;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Enum.TipoRuolo;
import it.arrp.c3.Model.Repository.ClienteRepository;
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
        if(locker == null || locker.getStatoAccensioneLocker() == Accensione.Spento)
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

    public void rimuoviBox(Long idCliente, Long idBoxAssegnato){
        getCliente(idCliente).removeBox(idBoxAssegnato);
    }

    public void rimuoviCheckpoint(Long idCliente){
        getCliente(idCliente).setCheckpoint(null);
    }

    //metodo per prendere tutti i box che sono assegnati ad un cliente
    public List<Box> getBoxCliente(Long uuidCliente) {
        return repoCliente.findOneById(uuidCliente).getBoxAssegnati();
    }

    public Cliente getCliente(Long id) {
        return repoCliente.findOneById(id);
    }

    public List<TipoRuolo> getListaRuoli(Long idCliente){
        Cliente cliente = getCliente(idCliente);
        return cliente.getListaRuoli();
    }

    /**
     * Apre il box che appartiene al cliente dato.
     * @param idCliente .
     * @param idBox .
     * @return NULL se il cliente o box non esiste, o il box non è presente nella sua lista.
     */
    //TODO aley n00b.    Da fixare, i service devono effettuare queste operazioni -A
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
        c.aggiungiRuolo(TipoRuolo.Corriere);
    }

    public void aggiungiRuoloTecnico(Long idCliente){
        Cliente cliente = repoCliente.findOneById(idCliente);
        cliente.aggiungiRuolo(TipoRuolo.Tecnico);
    }

    public void aggiungiRuoloNegozio(Long idCliente, String nomeNegozio, String cittaNegozio, GenereNegozio genere) {
        Cliente c = repoCliente.findOneById(idCliente);
        serviceNegozio.salvaRuoloNegozio(idCliente, nomeNegozio, cittaNegozio, genere);
        c.aggiungiRuolo(TipoRuolo.Negozio);
    }

    public boolean creaTicket(Long idCliente, String testo){
        return servMessaggio.creaTicket(idCliente,testo);
    }

    public void aggiungiRuoloAdmin(Long idCliente) {
        //TODO
    }
}