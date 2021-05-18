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
        Cliente cliente = repoCliente.findOneByIdCliente(idCliente);
        cliente.setCheckpoint(locker);
        repoCliente.save(cliente);
        return true;
    }

    /**
     * Inserisce nella lista Box di un cliente il Box assegnato per una corsa.
     * @param boxAssegnato Box da inserire.
     */
    public void assegnamentoBox(Long idCliente, Box boxAssegnato){
        Cliente c = repoCliente.findOneByIdCliente(idCliente);
        if(!(c == null)){
            c.addBox(boxAssegnato);
        }
        repoCliente.save(c);
    }

    public void rimuoviBox(Long idCliente, Long idBoxAssegnato){
        Cliente cliente = getCliente(idCliente);
        cliente.removeBox(idBoxAssegnato);
        repoCliente.save(cliente);
    }

    public void rimuoviCheckpoint(Long idCliente){
        Cliente cliente = getCliente(idCliente);
        cliente.setCheckpoint(null);
        repoCliente.save(cliente);
    }

    //metodo per prendere tutti i box che sono assegnati ad un cliente
    public List<Box> getBoxCliente(Long uuidCliente) {
        return repoCliente.findOneByIdCliente(uuidCliente).getBoxAssegnati();
    }

    public Cliente getCliente(Long id) {
        return repoCliente.findOneByIdCliente(id);
    }

    public List<TipoRuoloWrapper> getListaRuoli(Long idCliente){
        Cliente cliente = getCliente(idCliente);
        return cliente.getListaRuoli();
    }

    /**
     * Apre il box che appartiene al cliente dato.
     * @return NULL se il cliente o box non esiste, o il box non è presente nella sua lista.
     */
    public Box apriBox(Long idCliente, Long idBox){
        Cliente c = getCliente(idCliente);
        if(c == null)
            return null;
        Box b = serviceBox.getBox(idBox);
        if(b == null || !c.getBoxAssegnati().contains(b) || !b.getIdCliente().equals(idCliente))
            return null;
        serviceBox.unlock(idBox);
        c.removeBox(idBox);
        repoCliente.save(c);
        return b;
    }

    public Cliente registrazione(Cliente nuovo){
        if(nuovo.getNome().length() > 3 && nuovo.getPassword().length() > 3 && nuovo.getEmail().length() > 3 &&
        nuovo.getCitta().length() > 3) {
            repoCliente.save(nuovo);
            return nuovo;
        }else
            return null;
    }

    public void rimuoviRuolo(Long idCliente, TipoRuoloWrapper tipoRuolo){
        Cliente cliente = getCliente(idCliente);
        cliente.rimuoviRuolo(tipoRuolo);
        repoCliente.save(cliente);
    }

    public void aggiungiRuoloCorriere(Long idCliente, String mdt) {
        Cliente c = repoCliente.findOneByIdCliente(idCliente);
        serviceCorriere.salvaRuoloCorriere(idCliente,mdt);
        c.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Corriere));
    }

    public void aggiungiRuoloTecnico(Long idCliente){
        Cliente cliente = repoCliente.findOneByIdCliente(idCliente);
        cliente.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Tecnico));
    }

    public void aggiungiRuoloNegozio(Long idCliente) {
        Cliente c = repoCliente.findOneByIdCliente(idCliente);
        c.aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Negozio));
    }


    public boolean creaTicket(Long idCliente, String testo){
        return servMessaggio.creaTicket(idCliente,testo);
    }

    public void aggiungiRuoloAdmin(Long idCliente) {
        getCliente(idCliente).aggiungiRuolo(new TipoRuoloWrapper(TipoRuolo.Admin));

    }

    public List<Messaggio> getNotifiche(Long idCliente){
        return getCliente(idCliente).getNotifiche();
    }
}