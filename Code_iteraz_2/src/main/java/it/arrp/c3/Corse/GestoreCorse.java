package Corse;

import Sism.Sistema;

import java.util.ArrayList;
import java.util.Iterator;

public class GestoreCorse implements GestoreCorseInterface {

    private final Sistema sistema = Sistema.getInstance();
    private ArrayList<CorsaInterface> listaCorse;

    public GestoreCorse() {
        this.listaCorse = new ArrayList<>();
    }

    @Override
    public boolean removeCorsa(int codiceCorsa) {
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
    public CorsaInterface getCorsa(int codiceCorsa) {
        Iterator<CorsaInterface> iter = listaCorse.iterator();
        CorsaInterface c = null;
        while(iter.hasNext()){
            c = iter.next();
            if(c.getIdCorsa() == codiceCorsa)
                return c;
        }
        return null;
    }

}
