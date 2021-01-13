package Pacchi;

public class Pacco {
    @Override
    public boolean setCliente(int idCliente) {
        this.idCliente=idCliente;
        return true;
    }

    @Override
    public boolean setCommerciante(int idCommerciante) {
        this.idCommerciante=idCommerciante;
        return true;
    }
}
