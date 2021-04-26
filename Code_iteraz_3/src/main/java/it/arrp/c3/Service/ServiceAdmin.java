package it.arrp.c3.Service;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Admin.
 */
@Service
public class ServiceAdmin {
    @Autowired
    ServiceLocker serviceLocker;
    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    ServiceTecnico serviceTecnico;
    @Autowired
    AdminRepository repoAdmin;

    public  boolean creaRichiesta (Long idTecnico, String testoRichiesta){
        //TODO da implementare --Ric
        return true;
    }

    public boolean creaLocker(int latitudine, int longitudine, int dimensioniLocker){
        serviceLocker.generaLocker(latitudine,longitudine,dimensioniLocker);
        return true;
    }

    public Admin getAdmin(Long idAdmin){return repoAdmin.findOneById(idAdmin);}

    //TODO nella fase test check se funziona quel metodo nella repositoryAdmin -A
    public Admin getRandomAdmin(){ return repoAdmin.getRandomAdmin(); }

    public boolean creaTecnico(Long idCliente, Long idAdmin){
        Admin a = repoAdmin.findOneById(idAdmin);
        Cliente c = serviceCliente.getCliente(idCliente);
        if(a == null || c == null)
            return false;
        if(c.getListaRuoli().contains("Tecnico"))
            return true; //ritorna true perché anche se già presente, quel cliente é un tecnico... o no?
        return serviceTecnico.creaTecnico(idCliente,getAdmin(idAdmin)); //todo metodo da controllare in serviceTecnico
    }

}
