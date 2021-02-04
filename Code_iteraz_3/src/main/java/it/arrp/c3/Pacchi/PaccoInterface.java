package it.arrp.c3.Pacchi;

import java.util.UUID;

public interface PaccoInterface {

    UUID getIdCommerciante();
    UUID getIdCliente();
    UUID getIdPacco();
    void setIdCommerciante(UUID idCommerciante);
    void setIdCliente(UUID idCliente);

}
