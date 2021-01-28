package it.arrp.c3.Sism;//TODO cambiare nome al package... orrendo
                //Lasciare il package o modificare gli import di conseguenza nelle varie classi.
                // L'ho messo perché non mi faceva importare la classe in altro modo. | Riccardo
import it.arrp.c3.Corse.CorsaInterface;
import it.arrp.c3.Corse.GestoreCorseInterface;
import it.arrp.c3.Locker.GestoreLockerInterface;
import it.arrp.c3.Pacchi.GestorePacchiInterface;
import it.arrp.c3.Pacchi.PaccoInterface;
import it.arrp.c3.Utenti.GestoreUtentiInterface;

import java.util.ArrayList;

public class Sistema {

    private GestoreUtentiInterface gestoreUtentiInterface;
    private GestoreCorseInterface gestoreCorseInterface;
    private GestorePacchiInterface gestorePacchiInterface;
    private GestoreLockerInterface gestoreLockerInterface;
    private static Sistema istanza;

    private Sistema(){
        //TODO Implementare costruttore privato, che viene invocato dal getInstance()
    }

    public static Sistema getInstance(){
        //TODO Implementare metodo per avere un singleton
        return istanza;
    }

    public int generaNuovoId() {
        //TODO Implementare generatore Id
        return 0;
    }

    /* TODO da fare successivamente
    public boolean savePacco(ArrayList<? extends PaccoInterface> listaPacchi) {
        return true;
    }

    public boolean saveCorsa(ArrayList<? extends CorsaInterface> listaCorse) {
        return true;
    }
     */
}
