package Corse;

public interface CorsaInterface {

    void setCorriere(int idCorriere);
    void setLocker(int codiceLocker);
    void setPacco(int idPacco);
    //setID sarebbe meglio non farlo, in questo modo un oggetto non può cambiare id, rendendo tutto più solido -ale

    int getIdCorriere();
    int getIdPacco();
    int getIdLocker();
    int getIdCorsa();
}
