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


    public boolean creaTecnico(Long idCliente, Admin admin) {
        if(idCliente == null || admin == null)
            return false;
        serviceCliente.aggiungiRuoloTecnico(idCliente);
        repoTecnico.save(new Tecnico(idCliente,admin));
        return true;
    }

    public boolean creaRichiesta( Long idTecnico, String testoRichiesta){
        return serviceMessaggio.sendRichiesta(idTecnico,repoTecnico.findOneById(idTecnico).
                getAdmin().getIdCLiente(),testoRichiesta);
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