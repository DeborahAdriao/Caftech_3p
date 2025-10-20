package br.com.caftech.factory;

import br.com.caftech.decorator.Bebida;
import br.com.caftech.decorator.bebidas.Latte;

public class LatteFactory extends CafeteriaFactory {
    @Override
    public Bebida criarBebida() {
        return new Latte();
    }
}