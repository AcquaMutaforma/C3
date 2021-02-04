package it.arrp.c3.Corse;

import it.arrp.c3.Sism.Sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class GestoreCorse implements GestoreCorseInterface {

    private final Sistema sistema = Sistema.getInstance();
    private ArrayList<CorsaInterface> listaCorse;

    public GestoreCorse() {
        this.listaCorse = new ArrayList<>();
    }

    @Override
    public boolean removeCorsa(UUID codiceCorsa) {
        //TODO non deve eliminare dal cloud, li deve togliere solo dalla sua lista
        return listaCorse.remove(getCorsa(codiceCorsa));
    }

    /**
     * Aggiunge una corsa nella lista di quelli da salvare
     * @param c corsa da aggiungere alla lista
     */
    @Override
    public boolean addCorsa(CorsaInterface c) {
        return this.listaCorse.add(c);
    }

    @Override
    public CorsaInterface getCorsa(UUID codiceCorsa) {
        Iterator<CorsaInterface> iter = listaCorse.iterator();
        CorsaInterface c;
        while(iter.hasNext()){
            c = iter.next();
            if(c.getIdCorsa().equals(codiceCorsa))
                return c;
        }
        return null;
    }

}
