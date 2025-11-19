package br.com.caftech.factory;

import br.com.caftech.decorator.BebidaAbstrata;
import br.com.caftech.decorator.bebidas.Cappuccino;
import br.com.caftech.singleton.CardapioSingleton;

public class CappuccinoFactory extends CafeteriaFactory {
    @Override
    public BebidaAbstrata criarBebida() {
        double preco = CardapioSingleton.getInstancia().getPrecoItem("Cappuccino");
        return new Cappuccino(preco);
    }
}