package br.com.caftech.factory;

import br.com.caftech.decorator.Bebida;
import br.com.caftech.decorator.bebidas.CafeExpresso;

public class CafeExpressoFactory extends CafeteriaFactory {
    @Override
    public Bebida criarBebida() {
        return new CafeExpresso();
    }
}