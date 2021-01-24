package Sism;

import View.View;
import View.ViewInterface;

public class Index {

    private Sistema sistema;
    private ViewInterface view;
    private boolean state;

    public static void main(String[] args) {
        Index main = new Index();

    }

    public Index() {
        this.sistema = Sistema.getInstance();
        this.view = new View();
    }

    public boolean getStato(){
        return this.state;
    }

}
