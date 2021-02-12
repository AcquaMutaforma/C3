package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;

import java.util.UUID;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Cliente.
 */
public class ServiceCliente {
    ServiceLocker serviceLocker = new ServiceLocker();

    public void setCheckpoint(UUID uuidLocker){
        //TODO da implementare --Ric
    }
    public void assegnamentoBox(Box boxAssegnato){
        //TODO da implementare, non so se il parametro debba essere box o boxinterface (se esisterá ancora). --Ric
    }

    public Box getBoxCliente(UUID uuidCliente) {
        //TODO da implementare --Ric
        return serviceLocker.assegnaBox(uuidCliente);
    }
}