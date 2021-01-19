/**
 * Classe che genera gli ID per ogni oggetto creato.
 */
public class GestoreId implements GestoreIdInterface{
    //TODO aggiungerlo in Visual Paradigm
    //TODO puo' essere ottimizzato, ma per ora lasciamolo cosi'

    private int idBox;
    private int idLocker;

    public GestoreId() {
        this.idBox = 0;
        this.idLocker = 0;
    }

    //TODO inserire un costruttore con un parametro per ogni variabile, cosi' se lo dobbiamo caricare non riparte da 0

    @Override
    public int generaIdBox() {
        this.idBox++;
        return this.idBox;
    }

    @Override
    public int generaIdLocker() {
        this.idLocker++;
        return this.idLocker;
    }

}