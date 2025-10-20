package br.com.caftech.factory;

import br.com.caftech.decorator.Bebida;
import br.com.caftech.decorator.bebidas.Cappuccino;

public class CappuccinoFactory extends CafeteriaFactory {
    @Override
    public Bebida criarBebida() {
        return new Cappuccino();
    }
}