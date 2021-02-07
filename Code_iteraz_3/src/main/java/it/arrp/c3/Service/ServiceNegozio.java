package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;

import java.util.UUID;

public class ServiceNegozio {
    ServiceCliente serviceCliente = new ServiceCliente();
    ServiceCorsa serviceCorsa = new ServiceCorsa();

    public boolean addCorriere(UUID uuidCorriere){
        //TODO da implementare --Ric
        return true;
    }
    public boolean removeCorriere(UUID uuidCorriere){
        //TODO da implementare --Ric
        return true;
    }
    public UUID getCorriereDisponibile(){
        //TODO da implementare --Ric
        return null;
    }
    public void creaCorsa(UUID uuidCliente, UUID uuidCommerciante){
        UUID corriere =getCorriereDisponibile();
        if (corriere!=null){
            //da verificare se lasciarlo o meno, va a cozzare con il sequence diagram se si controlla quì il corriere. --Ric
            Box box =serviceCliente.getBoxCliente(uuidCliente);
            serviceCorsa.creaCorsa(uuidCliente,uuidCommerciante, corriere, box.getId());
        }
        //TODO da implementare --Ric
    }
}
