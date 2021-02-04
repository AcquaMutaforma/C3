package it.arrp.c3.Corse;

import java.util.UUID;

public interface CorsaInterface {

    void setCorriere(UUID idCorriere);
    void setLocker(UUID codiceLocker);
    void setPacco(UUID idPacco);
    //setID sarebbe meglio non farlo, in questo modo un oggetto non può cambiare id, rendendo tutto più solido -ale

    UUID getIdCorriere();
    UUID getIdPacco();
    UUID getIdLocker();
    UUID getIdCorsa();
}
