package it.arrp.c3.Service;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Repository.AdminRepository;
import it.arrp.c3.Model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
    ServiceMessaggio serviceMessaggio;
    @Autowired
    AdminRepository repoAdmin;

    public boolean creaRichiesta(Long idAdmin, Long idTecnico, String testoRichiesta){
        if(idAdmin == null || idTecnico == null || testoRichiesta.isEmpty())
            return false;
        return serviceMessaggio.sendRichiesta(idAdmin, idTecnico, testoRichiesta);
    }

    public boolean creaLocker(Long idAdmin, int latitudine, int longitudine, int dimensioniLocker){
        if(getAdmin(idAdmin) != null)
            return serviceLocker.generaLocker(latitudine, longitudine, dimensioniLocker);
        return false;
    }

    public Admin getAdmin(Long idAdmin){return repoAdmin.findOneById(idAdmin);}

    public Admin getRandomAdmin(){
        //return repoAdmin.getRandomAdmin();
        List<Admin> lista = repoAdmin.findAll();
        Random r = new Random(lista.size());
        return lista.get(r.nextInt());
    }

    /**
     * Metodo utilizzato da un admin per aggiungere un nuovo tecnico.
     * Nota: Ritorna true anche se il cliente e' gia' un tecnico.
     */
    public boolean creaTecnico(Long idCliente, Long idAdmin){
        Admin a = repoAdmin.findOneById(idAdmin);
        Cliente c = serviceCliente.getCliente(idCliente);
        if(a == null || c == null)
            return false;
        if(c.getListaRuoli().contains("Tecnico"))
            return true;
        return serviceTecnico.creaTecnico(idCliente,getAdmin(idAdmin)); //todo metodo da controllare in serviceTecnico
    }

    public boolean creaAdmin(Long idCliente, Long idAdmin, String citta) {
        Admin a = repoAdmin.findOneById(idAdmin);
        Cliente c = serviceCliente.getCliente(idCliente);
        if(a == null || c == null)
            return false;
        if(c.getListaRuoli().contains("Admin"))
            return true;
        serviceCliente.aggiungiRuoloAdmin(idCliente);
        repoAdmin.save(new Admin(idCliente,citta));
        return true;
    }

    //nota: il tecnico non dovrebbe avere l'autorita' per cambiare admin da solo, quindi ci pensa
    // l'admin con questo metodo, cambia per entrambi dato che non avrebbe senso che non siano " collegati"
    public List<Tecnico> aggiungiTecnico(Long idAdmin, Long idTecnico){
        Admin admin = getAdmin(idAdmin);
        Tecnico tec = serviceTecnico.getTecnico(idTecnico);
        if(admin == null || tec == null)
            return null;
        else {
            admin.addTecnico(tec);
            tec.setAdmin(admin);
            //todo: da valutare setCitta, se un tecnico cambia admin e' possibile che cambi anche citta -A
            tec.setCittaDiLavoro(admin.getCittaDiLavoro());
            return admin.getListaTecnici();
        }
    }


}
