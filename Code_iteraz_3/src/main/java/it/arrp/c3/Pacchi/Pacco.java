package it.arrp.c3.Pacchi;
public class Pacco implements PaccoInterface {

    int idCommerciante, idCliente, idPacco;

    public Pacco(int idPacco, int idCommerciante, int idCliente) {
        this.idPacco = idPacco;
        setIdCliente(idCliente);
        setIdCommerciante(idCommerciante);
    }

    public int getIdCommerciante() {
        return idCommerciante;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdPacco() {
        return idPacco;
    }

    public void setIdCommerciante(int idCommerciante) {
        this.idCommerciante = idCommerciante;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
