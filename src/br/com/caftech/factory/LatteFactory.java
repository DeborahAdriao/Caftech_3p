package br.com.caftech.factory;

import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.decorator.bebidas.Latte;
import br.com.caftech.singleton.CardapioSingleton;

public class LatteFactory extends CafeteriaFactory {
    @Override
    public BebidaAbstrata criarBebida() {
        double preco = CardapioSingleton.getInstancia().getPrecoItem("Latte");
        return new Latte(preco);
    }
}