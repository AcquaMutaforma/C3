package Pacchi;
public class Pacco implements PaccoInterface {
    int idCommerciante, idCliente;

    public Pacco(int idCommerciante, int idCliente) {
        setCliente(idCliente);
        setCommerciante(idCommerciante);
    }

    @Override
    public boolean setCliente(int idCliente) {
        //TODO opzione false o diventa void?
        this.idCliente=idCliente;
        return true;
    }

    @Override
    public boolean setCommerciante(int idCommerciante) {
        //TODO opzione false o diventa void?
        this.idCommerciante=idCommerciante;
        return true;
    }
}
