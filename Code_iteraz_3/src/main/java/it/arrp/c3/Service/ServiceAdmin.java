package it.arrp.c3.Service;

import it.arrp.c3.Model.*;
import it.arrp.c3.Model.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Admin.
 */
@Service
public class ServiceAdmin{
    @Autowired
    ServiceLocker serviceLocker;
    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    ServiceTecnico serviceTecnico;
    @Autowired
    ServiceMessaggio serviceMessaggio;
    @Autowired
    ServiceBox serviceBox;
    @Autowired
    AdminRepository repoAdmin;

    public boolean creaRichiesta(Long idAdmin, Long idTecnico, String testoRichiesta){
        if(idAdmin == null || idTecnico == null || testoRichiesta.isEmpty())
            return false;
        return serviceMessaggio.sendRichiesta(idAdmin, idTecnico, testoRichiesta);
    }

    public boolean creaLocker(Long idAdmin, int latitudine, int longitudine, int dimensioniLocker){
        Admin admin = getAdmin(idAdmin);
        if(admin != null)
            return serviceLocker.generaLocker(latitudine, longitudine, dimensioniLocker, admin.getCittaDiLavoro());
        return false;
    }

    public Admin getAdmin(Long idAdmin){return repoAdmin.findOneByIdCliente(idAdmin);}

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
        Admin a = repoAdmin.findOneByIdCliente(idAdmin);
        Cliente c = serviceCliente.getCliente(idCliente);
        if(a == null || c == null)
            return false;
        if(c.getListaRuoli().contains("TECNICO"))
            return true;
        return serviceTecnico.creaTecnico(idCliente,getAdmin(idAdmin));
    }

    public boolean creaAdmin(Long idCliente, Long idAdmin, String citta) {
        Admin a = repoAdmin.findOneByIdCliente(idAdmin);
        Cliente c = serviceCliente.getCliente(idCliente);
        if(a == null || c == null)
            return false;
        if(c.getListaRuoli().contains("ADMIN"))
            return true;
        serviceCliente.aggiungiRuoloAdmin(idCliente);
        repoAdmin.save(new Admin(idCliente,citta));
        return true;
    }

    //nota: il tecnico non dovrebbe avere l'autorita' per cambiare admin da solo, quindi ci pensa
    // l'admin con questo metodo, cambia per entrambi dato che non avrebbe senso che non siano " collegati"
    // idem per la citta di lavoro.
    public List<Tecnico> aggiungiTecnico(Long idAdmin, Long idTecnico){
        Admin admin = getAdmin(idAdmin);
        Tecnico tec = serviceTecnico.getTecnico(idTecnico);
        if(admin == null || tec == null)
            return null;
        else {
            admin.addTecnico(tec);
            tec.setAdmin(admin);
            tec.setCittaDiLavoro(admin.getCittaDiLavoro());
            return admin.getListaTecnici();
        }
    }

    private boolean controllaCitta(Long idAdmin, Long idLocker){
        Admin admin = getAdmin(idAdmin);
        Locker locker = serviceLocker.getLockerById(idLocker);
        return admin != null && locker != null && admin.getCittaDiLavoro().equals(locker.getCitta());
    }

    public Locker turnOnLocker(Long idAdmin, Long idLocker){
        if(controllaCitta(idAdmin, idLocker))
            serviceLocker.turnOnLocker(idLocker);
        return serviceLocker.getLockerById(idLocker);
    }

    public Locker turnOffLocker(Long idAdmin, Long idLocker){
        if(controllaCitta(idAdmin, idLocker))
            serviceLocker.turnOffLocker(idLocker);
        return serviceLocker.getLockerById(idLocker);
    }

    /*
    NOTA: I metodi che gestiscono i box fanno un sacco di giri in piu', per comodita' e per completare in tempo
    il progetto credo rimarranno cosi' dato che sono corretti, ma potrebbero essere ottimizzati in un secondo momento.

    Il check del box == null è necessario altrimenti se facciamo box.getLocker con box == null diventa null.getLocker
    e da NullPointerException
     */

    public Box turnOnBox(Long idAdmin, Long idBox){
        Box box = serviceBox.getBox(idBox);
        if(box == null)
            return null;
        if(controllaCitta(idAdmin, box.getLocker().getIdLocker()))
            serviceBox.turnOnBox(idBox);
        return box;
    }

    public Box turnOffBox(Long idAdmin, Long idBox){
        Box box = serviceBox.getBox(idBox);
        if(box == null)
            return null;
        if(controllaCitta(idAdmin, box.getLocker().getIdLocker()))
            serviceBox.turnOffBox(idBox);
        return box;
    }

    public Box unlockBox(Long idAdmin, Long idBox){
        Box box = serviceBox.getBox(idBox);
        if(box == null)
            return null;
        if(controllaCitta(idAdmin, box.getLocker().getIdLocker()))
            serviceBox.unlock(idBox);
        return box;
    }

    public Box lockBox(Long idAdmin, Long idBox){
        Box box = serviceBox.getBox(idBox);
        if(box == null)
            return null;
        if(controllaCitta(idAdmin, box.getLocker().getIdLocker()))
            serviceBox.lock(idBox);
        return box;
    }

}
