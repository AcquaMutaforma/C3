package Sism;//TODO cambiare nome al package... orrendo
                //Lasciare il package o modificare gli import di conseguenza nelle varie classi.
                // L'ho messo perché non mi faceva importare la classe in altro modo. | Riccardo
import Corse.CorsaInterface;
import Corse.GestoreCorseInterface;
import Locker.GestoreLocker;
import Pacchi.GestorePacchiInterface;
import Pacchi.PaccoInterface;
import Utenti.GestoreUtenti;

import java.util.ArrayList;

public class Sistema {

    private GestoreUtenti gestoreUtenti;
    private GestoreCorseInterface gestoreCorseInterface;
    //Modifiche provenienti dal refactor, non so se
    //debba rimanere cosí o cambiare (mi riferisco ai gestori di pacchi e corse) | Riccardo
    private GestorePacchiInterface gestorePacchiInterface;
    private GestoreLocker gestoreLocker;
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
