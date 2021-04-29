package it.arrp.c3.Service;

import it.arrp.c3.Model.Admin;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Repository.TecnicoRepository;
import it.arrp.c3.Model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Tecnico.
 */
@Service
public class ServiceTecnico {

    @Autowired
    ServiceCliente serviceCliente;
    @Autowired
    ServiceLocker serviceLocker;
    @Autowired
    ServiceMessaggio serviceMessaggio;
    @Autowired
    ServiceBox serviceBox;
    @Autowired
    TecnicoRepository repoTecnico;
    Locker lockerAttivo; //TODO da aggiungere metodi di "locking" di un locker ad un tecnico (anche nel vpp) --Ric

    public boolean creaTecnico(Long idCliente, Admin admin) {
        serviceCliente.aggiungiRuoloTecnico(idCliente);
        repoTecnico.save(new Tecnico(idCliente,admin));
        //TODO da controllare, mi sembra vada bene ora. --Ric
        return true;
    }

    public boolean creaRichiesta(String testoRichiesta, Long idTecnico){
        Long idAdmin= repoTecnico.getOne(idTecnico).getAdmin().getIdCLiente();
        serviceMessaggio.sendRichiesta(idTecnico,idAdmin,testoRichiesta);
        return true;
        //TODO da modificare il valore di ritorno in base al fatto che vada in porto o meno la consegna(?) --Ric
    }

    public void turnOnLocker(Long idLocker){
        serviceLocker.turnOnLocker(idLocker);
    }
    public void turnOffLocker(Long idLocker){
        serviceLocker.turnOffLocker(idLocker);
    }
    public void turnOnBox(Long idBox){
        serviceBox.turnOnBox(idBox);
    }
    public void turnOffBox(Long idBox){
        serviceBox.turnOffBox(idBox);
    }

    //TODO da inserire tutti i comandi che puo' eseguire il tecnico
}