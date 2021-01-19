import Corse.GestoreCorseInterface;
import Locker.GestoreLocker;
import Pacchi.GestorePacchiInterface;
import Utenti.GestoreUtenti;
public class Sistema {

    private GestoreUtenti gestoreUtenti;
    private GestoreCorseInterface gestoreCorseInterface;
    //Modifiche provenienti dal refactor, non so se
    //debba rimanere cosí o cambiare (mi riferisco ai gestori di pacchi e corse) | Riccardo
    private GestorePacchiInterface gestorePacchiInterface;
    private GestoreLocker gestoreLocker;
