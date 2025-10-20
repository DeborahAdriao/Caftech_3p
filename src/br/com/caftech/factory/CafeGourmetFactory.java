package br.com.caftech.factory;

import br.com.caftech.decorator.Bebida;
import br.com.caftech.decorator.bebidas.CafeGourmet;

public class CafeGourmetFactory extends CafeteriaFactory {
    @Override
    public Bebida criarBebida() {
        return new CafeGourmet();
    }
}