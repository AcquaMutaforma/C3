package it.arrp.c3.Model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Questa classe rappresenta il ruolo di un utente, ossia il Corriere.
 * Con questo ruolo si possono effettuare consegne ai vari locker per conto
 * dei vari negozi per cui si é registrati.
 */
public class Corriere extends Ruolo {
    public String mezzoDiTrasporto;
    public ArrayList<Negozio> listaNegoziCollegati= new ArrayList<>();


    public boolean rimuoviNegozio(UUID uuidNegozio) {
        //TODO da implementare.
        return true;
    }
}
