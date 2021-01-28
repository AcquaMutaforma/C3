package it.arrp.c3.Pacchi;

import it.arrp.c3.Sism.Sistema;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorePacchi implements GestorePacchiInterface {

    private final Sistema sistema = Sistema.getInstance();
    private ArrayList<PaccoInterface> listaPacchi;

    public GestorePacchi() {
        this.listaPacchi = new ArrayList<>();
    }

    /**
     * Aggiunge un pacco nella lista di quelli da salvare
     * @param p .
     */
    @Override
    public boolean addPacco(PaccoInterface p) {
        return listaPacchi.add(p);
    }

    @Override
    public boolean removePacco(int idPacco) {
        return this.listaPacchi.remove(getPacco(idPacco));
    }

    @Override
    public PaccoInterface getPacco(int idPacco) {
        Iterator<PaccoInterface> iter = listaPacchi.iterator();
        PaccoInterface p;
        while(iter.hasNext()){
            p = iter.next();
            if(p.getIdPacco() == idPacco)
                return p;
        }
        return null;
    }

    @Override
    public PaccoInterface creaPacco(int idPacco, int idCommerciante, int idCliente) {
        return null;
    }

}
