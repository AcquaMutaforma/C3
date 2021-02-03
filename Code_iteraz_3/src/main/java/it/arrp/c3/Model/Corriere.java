package it.arrp.c3.Model;

import java.util.ArrayList;
import java.util.UUID;

public class Corriere extends UtenteRegistrato {
    public String mezzoDiTrasporto;
    public ArrayList<Commerciante> listaNegoziCollegati= new ArrayList<>();


    public boolean rimuoviNegozio(UUID uuidNegozio) {
        //TODO da implementare.
        return true;
    }
}
