package br.com.caftech.factory;

import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.decorator.bebidas.CafeExpresso;
import br.com.caftech.singleton.CardapioSingleton;

public class CafeExpressoFactory extends CafeteriaFactory {
    @Override
    public BebidaAbstrata criarBebida() {
        double preco = CardapioSingleton.getInstancia().getPrecoItem("Expresso");
        return new CafeExpresso(preco);
    }
}