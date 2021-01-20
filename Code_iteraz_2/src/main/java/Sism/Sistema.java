package Sism;//TODO cambiare nome al package... orrendo
                //Lasciare il package o modificare gli import di conseguenza nelle varie classi.
                // L'ho messo perché non mi faceva importare la classe in altro modo. | Riccardo
import Corse.CorsaInterface;
import Corse.GestoreCorseInterface;
import Locker.GestoreLockerInterface;
import Pacchi.GestorePacchiInterface;
import Pacchi.PaccoInterface;
import Utenti.GestoreUtentiInterface;

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

    public boolean savePacco(ArrayList<? extends PaccoInterface> listaPacchi) {
        //TODO Implementare Saver per i pacchi
        return true;
    }

    public boolean saveCorsa(ArrayList<? extends CorsaInterface> listaCorse) {
        //TODO Implementare Saver per le corse
        return true;
    }
}
